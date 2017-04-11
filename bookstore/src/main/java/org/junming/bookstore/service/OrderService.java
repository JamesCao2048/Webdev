package org.junming.bookstore.service;

import org.junming.bookstore.model.Order;

import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */
public interface OrderService {
    public Order getOrderById(int id);
    public List<Order> getOrders();
    public List<Order> getOrderByUserId(String uid);
    public int insertOrder(Order order);
}
