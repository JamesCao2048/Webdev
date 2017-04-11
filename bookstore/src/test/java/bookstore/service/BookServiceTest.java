package bookstore.service;

import bookstore.test.BaseTest;
import org.junit.Test;
import org.junming.bookstore.model.Book;
import org.junming.bookstore.model.User;
import org.junming.bookstore.service.BookService;
import org.junming.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */
public class BookServiceTest extends BaseTest {
    @Autowired
    BookService b;

    @Test
    public void testGetBooks(){
        List<Book> booklist=b.getBooks();
        for(Book item : booklist)
            System.out.println(item);
    }

    @Test
    public void testGetBookById(){
        System.out.println(b.getBookById("333"));
    }

   /* @Test
    public void testInsertBook(){
        Book bo= new Book();
        bo.setId("bid");
        bo.setAuthor("bau");
        bo.setName("bname");
        bo.setPrice(12);
        bo.setStock(321);
        bo.setType("btype");

        System.out.println(b.insertBook(bo));
    }
*/

}
