package web;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import bookstore.test.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import org.junming.bookstore.controller.HomeController;
/*
public class HomeControllerTest extends BaseTest {

  @Test
  public void testHomePage() throws Exception {
    HomeController controller = new HomeController();
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(get("/"))
           .andExpect(view().name("index"));
    mockMvc.perform(get("/adm"))
            .andExpect(view().name("admPage"));
  }

}*/