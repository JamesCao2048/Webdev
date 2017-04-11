package org.junming.bookstore.service;

import org.junming.bookstore.model.Book;
import org.junming.bookstore.model.Cart;
import org.junming.bookstore.model.Order;

import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */
public interface CartService {

    public void addBook(Book book);
    public Cart getCart();
    public int getPrice();
    public Order generateOrder(String uid);
    public boolean haveBook(String bid);
}
