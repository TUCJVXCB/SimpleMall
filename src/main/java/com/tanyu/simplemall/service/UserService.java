package com.tanyu.simplemall.service;

import com.tanyu.simplemall.DAO.UserDAO;
import com.tanyu.simplemall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    User getUserByName(String name) {
        User user = userDAO.getUserByName(name);
        return user;
    }
}
