package vitalii.bozadzhy.security;

import vitalii.bozadzhy.exception.AuthenticationException;
import vitalii.bozadzhy.exception.RegistrationException;
import vitalii.bozadzhy.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password) throws RegistrationException;
}
