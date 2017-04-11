package org.junming.bookstore.service;

import org.junming.bookstore.dao.BookDAO;
import org.junming.bookstore.dao.OrderDAO;
import org.junming.bookstore.model.Book;
import org.junming.bookstore.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */
@Service
@Transactional
public class OrderServiceIml implements OrderService {
    @Autowired
    OrderDAO orderdao;
    @Autowired
    BookDAO bookDAO;

    private Order setBooksForOrder(Order o){
        o.setBooks(bookDAO.getBookByOrderId(o.getOid()));
        return o;
    }

    private void insertBooksForOrder(Order order){
        for (Book b : order.getBooks())
        {   orderdao.insertOrderBooks(order.getOid(), b.getId() );
            bookDAO.sellBookById(b.getId());
        }
    }

    @Override
    public Order getOrderById(int id){
        return setBooksForOrder(orderdao.getOrderById(id));
    }

    @Override
    public List<Order> getOrders(){
        List<Order> listorder=orderdao.getOrders();
        for (Order o: listorder)
            setBooksForOrder(o);
        return listorder;
    }

    @Override
    public List<Order> getOrderByUserId(String uid){
        List<Order> listorder=orderdao.getOrderByUserId(uid);
        for (Order o: listorder)
            setBooksForOrder(o);
        return listorder;
    }

    @Override
    public int insertOrder(Order order){
            orderdao.insertOrder(order);
            //order.setOid(id);
            insertBooksForOrder(order);
        return order.getOid();
    }
}
