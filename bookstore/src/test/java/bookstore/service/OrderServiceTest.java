package bookstore.service;

import bookstore.test.BaseTest;
import org.junit.Test;
import org.junming.bookstore.model.Book;
import org.junming.bookstore.model.Order;
import org.junming.bookstore.service.BookService;
import org.junming.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by john on 2017/3/18 0018.
 */
public class OrderServiceTest extends BaseTest {
    @Autowired
    OrderService o;

    @Autowired
    BookService b;

    @Test
    public void testGetOrderById()
    {
        System.out.println(o.getOrderById(7));
    }

    @Test
    public  void TestGetOrders(){
        List<Order> orders=o.getOrders();

        for (Order item:orders)
        System.out.println(item);
    }

    @Test
    public  void TestGetOrderByUserId(){
        System.out.println(o.getOrderByUserId("1"));
    }

   /* @Test
    public void TestInsertOrder(){
        List<Book> books=b.getBooks();
        Order order= new Order();
        order.setTime(new Timestamp(new Date().getTime()));
       // order.setTime("2017-2-3 15:01:58");
        order.setBooks(books);
        order.setUid("haha");
        order.setToPrice(order.calToPeice());
        System.out.println(o.insertOrder(order));
    }*/
}
