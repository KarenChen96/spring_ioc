package com.cecilia.service.impl;

import com.cecilia.dao.UserDao;
import com.cecilia.domain.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    // Demo: Dependency Injection for referenced objects.
    private UserDao userDao;

    // Demo: Dependency Injection via setters.
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // Demo: Dependency Injection via constructor with arguments.
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        userDao.save();
        System.out.print("We are is business tier now...");
    }
}
