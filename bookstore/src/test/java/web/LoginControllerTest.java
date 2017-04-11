package web;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import bookstore.test.BaseTest;
import org.junit.Test;
import org.junming.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

//import org.junming.bookstore.controller.LoginController;

/**
 * Created by john on 2017/3/17 0017.
 */
/*
public class LoginControllerTest extends BaseTest {
    @Autowired
    UserService u;

    @Test
    public void testLogin() throws Exception {
       // System.out.println(u.getUserById("dogliang23"));
        LoginController controller = new LoginController(u);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/login")
                .param("id", "dogliang23")
                .param("password", "haha"))
                .andExpect(view().name("loginSuc"));
    }

}
*/