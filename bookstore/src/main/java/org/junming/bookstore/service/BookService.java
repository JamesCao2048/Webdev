package org.junming.bookstore.service;

import org.junming.bookstore.model.Book;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */
public interface BookService {
    public List<Book> getBooks();
    public Book getBookById(String id);
    public boolean insertBook(Book book);
    public boolean ifAnyStock(String id);
    public List<Book> getFilterBooks(List<GrantedAuthority> grantedAuthorityList) throws Exception;
}
