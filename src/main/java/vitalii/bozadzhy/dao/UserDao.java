package vitalii.bozadzhy.dao;

import java.util.Optional;
import vitalii.bozadzhy.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);
}
