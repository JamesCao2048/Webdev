package org.junming.bookstore.service;

import org.junming.bookstore.dao.BookDAO;
import org.junming.bookstore.util.BookPermissionDAO;
import org.junming.bookstore.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */

@Service
@Transactional
public class BookServiceIml implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private BookPermissionDAO bookPermissionDAO;

    @Autowired
    private LogService logService;

    @Override
    public Book getBookById(String id) {
        logService.logInfo(UserServiceIml.class,"get book by id:"+id);
        return bookDAO.getBookById(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Override
    public boolean insertBook(Book book) {
        return bookDAO.insertBook(book);
    }

    @Override
    public boolean ifAnyStock(String id) {
        return bookDAO.getBookById(id).getStock() > 0;
    }

    @Override
    public List<Book> getFilterBooks(List<GrantedAuthority> grantedAuthorities) throws Exception {
        List<Book> books = bookDAO.getBooks();
        List<String> roles = new ArrayList<String>();
        if (grantedAuthorities!=null &&
                grantedAuthorities.contains(new SimpleGrantedAuthority("ROLE_ADM"))) {
            roles.add("ADM");
        }
        roles.add("USER");
        List<String> permission = bookPermissionDAO.getPermissionByRoleList(roles);

        List<Book> remove=new ArrayList<>();
        for(Book b : books)
        {
            String re=b.getType().toUpperCase();
            boolean flag= permission.contains(re);
            if(!flag)
                remove.add(b);
        }
        for(Book r:remove)
            books.remove(r);
        return books;
    }
}
