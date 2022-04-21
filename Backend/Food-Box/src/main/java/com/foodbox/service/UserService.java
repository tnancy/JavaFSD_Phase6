package com.foodbox.service;

import com.foodbox.DAO.DAO;
import com.foodbox.DAO.UserDAO;
import com.foodbox.model.Product;
import com.foodbox.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final DAO<User> userDAO;

    public UserService(@Autowired UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public Boolean changePassword(String username, String pass) {
        ((UserDAO) this.userDAO).update(username, pass);
        return true;
    }
    
    public User add(User user) {
        return ((UserDAO) userDAO).addUser(user);
    }
}
