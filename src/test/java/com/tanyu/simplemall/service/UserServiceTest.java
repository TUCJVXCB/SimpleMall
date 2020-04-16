package com.tanyu.simplemall.service;

import com.tanyu.simplemall.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getUserByName() {
        User user = userService.getUserByName("admin");
        System.out.println(user);
    }
}