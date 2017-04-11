package org.junming.bookstore.controller;

import org.junming.bookstore.dao.UserDAO;
import org.junming.bookstore.model.User;
import org.junming.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by john on 2016/7/7 0007.
 */

@Controller
public class LoginController {

    //private UserService userService;
    @Autowired
    UserDetailsService userDetailsService;

    public LoginController(){
        //this.userService=u;
    }
    @RequestMapping(value="/login")
    public String loginProcess(User u, HttpServletRequest request, HttpServletResponse response){

        if(userDetailsService.loadUserByUsername(u.getId()).getPassword().equals(u.getPassword())){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null ){
                new SecurityContextLogoutHandler().logout(request, response, auth);
           }
            UserDetails userDetails = userDetailsService.loadUserByUsername(u.getId());
            Authentication newauth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword(),
                    userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(newauth);
            return "loginSuc";
        }
        else
            return "redirect:/";
    }
}