package bookstore.dao;

import bookstore.test.BaseTest;
import org.junit.Test;
import org.junming.bookstore.dao.BookDAO;
import org.junming.bookstore.dao.UserDAO;
import org.junming.bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by john on 2017/3/18 0018.
 */
public class BookDAOTest extends BaseTest {
    @Autowired
    private BookDAO bookDao;

    @Test
    public void testSellBookById() throws Exception{
        bookDao.sellBookById("2");
    }
}
