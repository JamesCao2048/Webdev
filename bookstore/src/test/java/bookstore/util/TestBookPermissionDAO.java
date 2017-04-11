package bookstore.util;

import org.junit.Test;
import org.junming.bookstore.util.BookPermissionDAO;
import org.junming.bookstore.util.BookPermissionDAOIml;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/3/19 0019.
 */
public class TestBookPermissionDAO {

    @Test
    public void test()
    {
        BookPermissionDAO b=new BookPermissionDAOIml();
        List<String> role= new ArrayList<String>();
        role.add("USER");
       // System.out.println(b.getPermissionByRoleList(role));
    }
}
