package org.junming.bookstore.controller;

import org.junming.bookstore.model.Book;
import org.junming.bookstore.model.Order;
import org.junming.bookstore.model.User;
import org.junming.bookstore.service.BookService;
import org.junming.bookstore.service.CartService;
import org.junming.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by john on 2017/3/18 0018.
 */
@Controller
@RequestMapping(value="/book")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView bookPage(HttpServletRequest request,
                                              HttpServletResponse response)throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> auths= new ArrayList<GrantedAuthority>(auth.getAuthorities());
        Map<String,Object> map=new HashMap<>();
        List<Book> booklist= bookService.getFilterBooks(auths);
        map.put("books",  booklist);
        return new ModelAndView("bookPage",map);
    }

    @RequestMapping(value = "/ajax/{count}", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> bookAjax(@PathVariable("count") int count) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> auths= new ArrayList<GrantedAuthority>(auth.getAuthorities());
        List<Book> booklist= bookService.getFilterBooks(auths);
        System.out.println("count:"+count);
        return booklist;
    }

    @RequestMapping(value="/cart/viewcart",method = RequestMethod.GET)
    public ModelAndView cartAddBook() throws Exception{
        Map<String,Object> map=new HashMap<>();
        List<Book> booklist= cartService.getCart().getBooks();
        map.put("cartBooks", booklist);
        return new ModelAndView("cartPage",map);
    }
    @RequestMapping(value="/cart/addbook")
    public ModelAndView cartAddBook(String bookId) throws Exception{
        if(!bookService.ifAnyStock(bookId)||cartService.haveBook(bookId))
            return new ModelAndView("redirect:/book");
        else{
        cartService.addBook(bookService.getBookById(bookId));
        Map<String,Object> map=new HashMap<>();
        List<Book> booklist= cartService.getCart().getBooks();
        map.put("cartBooks",booklist);
        return new ModelAndView("cartPage",map);
        }
    }
    @RequestMapping(value="/order/neworder")
    public ModelAndView cartOrder(HttpServletRequest request) throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Order order = cartService.generateOrder(auth.getName());
        orderService.insertOrder(order);
        Map<String,Object> map=new HashMap<>();
        List<Order> orderlist=orderService.getOrderByUserId(order.getUid());
        map.put("orders",orderlist);
        return new ModelAndView("orderPage",map);
    }
    @RequestMapping(value="/order/vieworder")
    public ModelAndView viewOrder(HttpServletRequest request) throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Map<String,Object> map=new HashMap<>();
        List<Order> orderlist=orderService.getOrderByUserId(auth.getName());
        orderlist= orderlist==null? new ArrayList<Order>():orderlist;
        map.put("orders",orderlist);
        return new ModelAndView("orderPage",map);
    }
}
