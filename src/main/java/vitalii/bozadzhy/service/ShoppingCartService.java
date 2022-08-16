package vitalii.bozadzhy.service;

import vitalii.bozadzhy.model.MovieSession;
import vitalii.bozadzhy.model.ShoppingCart;
import vitalii.bozadzhy.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clearShoppingCart(ShoppingCart cart);
}
