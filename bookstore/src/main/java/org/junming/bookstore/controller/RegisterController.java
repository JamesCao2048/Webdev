package org.junming.bookstore.controller;

import org.junming.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.junming.bookstore.dao.UserDAO;
import org.junming.bookstore.model.User;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by john on 2016/7/7 0007.
 */
@Controller
public class RegisterController {
    private UserService userservice;
    @Autowired
    public RegisterController(UserService u){
        this.userservice=u;
    }
    @RequestMapping("/register")
    public String registerProcess(User u, ModelAndView model, HttpServletRequest request){
        if(userservice.insertUser(u)){
            request.getSession().setAttribute("userid",u.getId());
            request.getSession().setAttribute("name",u.getName());
            return "registerSuc";
        }
        else
            return "redirect:/";
    }
}