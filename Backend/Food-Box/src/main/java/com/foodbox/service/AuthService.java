package com.foodbox.service;

import com.foodbox.DAO.UserDAO;
import com.foodbox.exception.InvalidCredentialsException;
import com.foodbox.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Service
public class AuthService {
    private final UserDAO userDAO;

    public AuthService(@Autowired UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    private User isAuthenticated(String username, String password) throws Exception {
        User user = userDAO.getUserByUsername(username);
        if (user.getPassword().equals(password)) return user;
        else return null;
    }

    public User authenticate(String authHeader) {
        String base64 = authHeader.substring(6);
        String userpass = new String(Base64.getDecoder().decode(base64));
        String[] creds = userpass.split(":");
        User auth = null;
        try {
            auth = isAuthenticated(creds[0], creds[1]);
        } catch (Exception e) {
            throw new InvalidCredentialsException();
        }

        if (auth == null) throw new InvalidCredentialsException();
        return auth;
    }
}
