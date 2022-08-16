package vitalii.bozadzhy.service;

import java.util.List;
import vitalii.bozadzhy.model.Order;
import vitalii.bozadzhy.model.ShoppingCart;
import vitalii.bozadzhy.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
