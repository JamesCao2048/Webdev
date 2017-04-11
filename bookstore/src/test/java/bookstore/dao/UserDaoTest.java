package bookstore.dao;

import bookstore.test.BaseTest;
import org.junit.Test;
import org.junming.bookstore.dao.UserDAO;
import org.junming.bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;

/**
 * Created by john on 2017/3/17 0017.
 */
// 告诉junit spring配置文件

public class UserDaoTest extends BaseTest {
    @Autowired
    private UserDAO userDao;

    @Test
    public void testUserLogin() throws Exception{
        String username = "dogliang23";
        String password = "tom";
        User u = userDao.getUserById(username);
        if (u == null)
            System.out.println("Login Failed");
        else
            System.out.println("Login Success");
    }
}