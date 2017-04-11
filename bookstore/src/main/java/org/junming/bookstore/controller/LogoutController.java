package org.junming.bookstore.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
/**
 * Created by john on 2016/7/9 0009.
*/

@Controller
public class LogoutController {
    @RequestMapping(value="/logouter",method = RequestMethod.GET)
    public String logoutProcess(HttpServletRequest request, HttpServletResponse response){
        /*request.getSession().removeAttribute("userid");
        request.getSession().removeAttribute("admid");
        request.getSession().removeAttribute("name");
        request.getSession().invalidate();
        return "redirect:/";*/
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
            //request.getSession().invalidate();
        }
        return "redirect:/";
    }
}