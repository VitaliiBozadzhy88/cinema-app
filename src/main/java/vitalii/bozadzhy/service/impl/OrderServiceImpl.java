package vitalii.bozadzhy.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import vitalii.bozadzhy.dao.OrderDao;
import vitalii.bozadzhy.lib.Inject;
import vitalii.bozadzhy.lib.Service;
import vitalii.bozadzhy.model.Order;
import vitalii.bozadzhy.model.ShoppingCart;
import vitalii.bozadzhy.model.User;
import vitalii.bozadzhy.service.OrderService;
import vitalii.bozadzhy.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setUser(shoppingCart.getUser());
        order.setOrderDate(LocalDateTime.now());
        order.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        shoppingCartService.clearShoppingCart(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersByUser(user);
    }
}
