package com.shiyaoeating.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppJungle {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/shiyaoeating/spring/test/beans/junglebean.xml");
        
        Jungle jungle = (Jungle)context.getBean("jungle");
        
        System.out.println(jungle);
        
        ((ClassPathXmlApplicationContext)context).close();
    }
}