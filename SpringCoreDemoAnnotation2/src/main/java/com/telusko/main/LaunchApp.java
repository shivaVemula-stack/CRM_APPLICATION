package com.telusko.main;

import com.telusko.config.Password;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("appConfig.xml");
        Password pwd = container.getBean(Password.class);
        System.out.println(pwd.algoInfo());
    }
}
