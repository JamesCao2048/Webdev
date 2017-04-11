package bookstore.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junming.bookstore.controller.HomeController;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件

@ContextConfiguration(classes = org.junming.bookstore.config.MvcConfiguration.class)
@WebAppConfiguration
public class BaseTest {
    @Test
    public void test() throws Exception {
        return;
    }
}