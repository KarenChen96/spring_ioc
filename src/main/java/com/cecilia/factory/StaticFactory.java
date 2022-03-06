package com.cecilia.factory;

import com.cecilia.dao.UserDao;
import com.cecilia.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
