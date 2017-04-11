package bookstore.util;

import bookstore.test.BaseTest;
import org.junit.Test;
import org.junming.bookstore.util.LoadBookPermission;

/**
 * Created by john on 2017/3/19 0019.
 */
public class TestLoadBookPermission  {

    @Test
    public void testLoad() throws Exception{
        System.out.println(LoadBookPermission.loadBookPermission());
    }
}
