package vitalii.bozadzhy.dao;

import java.util.List;
import vitalii.bozadzhy.model.Order;
import vitalii.bozadzhy.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersByUser(User user);
}
