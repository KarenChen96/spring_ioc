package com.cecilia.test;

import com.cecilia.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemoTest {
    @Test
    // Test scope: how many beans will be created?
    // singleton (default value): one; prototype: multiple, depends on how many times getBean() is called?
    public void test_scope() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) context.getBean("userDao");
        UserDao userDao2 = (UserDao) context.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
    }

    @Test
    // Test scope: when is (each) beans created?
    // singleton (default value): when loadng the appContext; Be destroyed when Spring container is destroyed.
    // prototype: when getBean() is called; Be GCed if not be used for a long time
    public void test_creation_time() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) context.getBean("userDao");
        UserDao userDao2 = (UserDao) context.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2); // Check when strings will be printed
    }

    @Test
    public void test_init_destroy() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) context.getBean("userDao");
        System.out.println(userDao1);
        // Manually close the container so that destroy() message can be printed.
        // And this will only works if scope is set as singleton!
        ((ClassPathXmlApplicationContext) context).close();
    }


}
