package web;

import bookstore.test.BaseTest;
import org.junit.Test;
import org.junming.bookstore.controller.RegisterController;
import org.junming.bookstore.model.User;
import org.junming.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by john on 2017/3/18 0018.
 */
/*
public class RegisterControllerTest extends BaseTest {
    @Autowired
    UserService u;

    @Test
    public void testRegister() throws Exception {
        //System.out.println(u.getUserById("dogliang23"));
        RegisterController controller = new RegisterController(u);
        MockMvc mockMvc = standaloneSetup(controller).build();
        User user= new User("id","pw","name","email","22",1);
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("id", user.getId()).param("password",user.getPassword()).param("email",user.getEmail())
                .param("gender",user.getGender()).param("age", Integer.toString(user.getAge())).param("name",user.getName())
        ).andExpect(view().name("registerSuc"));
    }
}
*/