package org.junming.bookstore.dao;

import org.apache.ibatis.annotations.Param;
import org.junming.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */
@Repository
public interface BookDAO {
    public Book getBookById(@Param("id") String id);
    public List<Book> getBookByOrderId(@Param("oid") int id);
    public boolean insertBook(@Param("book") Book book);
    public List<Book> getBooks();
    public void sellBookById(@Param("id") String id);
}
