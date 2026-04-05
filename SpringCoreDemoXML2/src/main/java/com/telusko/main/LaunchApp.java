package com.telusko.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("appConfig.xml");
        Telusko tel = container.getBean(Telusko.class);
//        Telusko tel = (Telusko) container.getBean("telusko"); // getting the bean by it's id and downcasting
//        Telusko tel = container.getBean("telusko",Telusko.class)
        tel.buyTheCourse(5000);

    }
}
