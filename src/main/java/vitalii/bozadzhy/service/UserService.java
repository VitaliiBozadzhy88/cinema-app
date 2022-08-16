package vitalii.bozadzhy.service;

import java.util.Optional;
import vitalii.bozadzhy.model.User;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
