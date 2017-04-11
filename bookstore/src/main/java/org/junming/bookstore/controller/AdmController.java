package org.junming.bookstore.controller;

import org.junming.bookstore.model.Book;
import org.junming.bookstore.model.User;
import org.junming.bookstore.service.BookService;
import org.junming.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by john on 2017/3/18 0018.
 */

@Controller
@RequestMapping(value="/adm")
public class AdmController {
    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @RequestMapping(
            method = RequestMethod.GET)
    public ModelAndView handleRequestInternal(HttpServletRequest request,
                                              HttpServletResponse response)throws Exception{
        Map<String,Object> map=new HashMap<>();
        List<User> userlist= userService.getUsers();
        List<Book> booklist= bookService.getBooks();

        map.put("users",  userlist);
        map.put("books",  booklist);
        return new ModelAndView("admPage",map);
    }
}
