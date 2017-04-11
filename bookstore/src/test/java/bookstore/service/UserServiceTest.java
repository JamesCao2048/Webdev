package bookstore.service;

import bookstore.test.BaseTest;
import org.junit.Test;
import org.junming.bookstore.model.User;
import org.junming.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */
public class UserServiceTest extends BaseTest {
    @Autowired
    UserService u;

    @Autowired
    UserDetailsService ud;

    @Test
    public void testGetUsers(){
        List<User> userlist=u.getUsers();
        for(User item : userlist)
            System.out.println(item);
    }
    @Test
    public void checkAdm(){
        System.out.println(u.ifAdm("haha"));
        System.out.println(u.ifAdm("234"));
    }

    @Test
    public void testLoadUserByName(){
        System.out.println(ud.loadUserByUsername("junming"));
        //System.out.println(ud.loadUserByUsername("2"));
    }
}
