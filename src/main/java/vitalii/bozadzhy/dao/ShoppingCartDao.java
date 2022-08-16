package vitalii.bozadzhy.dao;

import vitalii.bozadzhy.model.ShoppingCart;
import vitalii.bozadzhy.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
