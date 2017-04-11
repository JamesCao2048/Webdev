package org.junming.bookstore.service;

import org.junming.bookstore.model.Book;
import org.junming.bookstore.model.Cart;
import org.junming.bookstore.model.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */
@Service
@Transactional
@Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class CartServiceIml implements CartService , Serializable  {
    Cart cart;

    public CartServiceIml(){cart =new Cart();}

    @Override
    public void addBook(Book book){cart.getBooks().add(book);}

    @Override
    public Cart getCart(){return cart;}

    @Override
    public int getPrice(){
        int result=0;
        List<Book> booklist = cart.getBooks();
        for (Book b : booklist)
            result+=b.getPrice();
        return result;
    }

    @Override
    public Order generateOrder(String uid){
        Order o =new Order();
        o.setUid(uid);
        o.setBooks(new ArrayList<Book>(cart.getBooks()));
        o.setTime(new Timestamp(new Date().getTime()));
        o.setToPrice(getPrice());
        cart.clearCart();
        return o;
    }

    @Override
    public boolean haveBook(String id){
        for (Book b : cart.getBooks())
            if(b.getId().equals(id))
                return true;
        return false;
    }
}
