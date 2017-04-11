package org.junming.bookstore.dao;

import org.apache.ibatis.annotations.Param;
import org.junming.bookstore.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */
@Repository
public interface OrderDAO {
    public int insertOrder(Order o);
    public void insertOrderBooks(@Param("oid") int oid, @Param("bid") String bid);

    public Order getOrderById(@Param("id") int id);
    public List<Order> getOrders();
    public List<Order> getOrderByUserId(@Param("uid") String uid);
}
