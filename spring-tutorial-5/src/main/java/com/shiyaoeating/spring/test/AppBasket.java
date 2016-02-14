package com.shiyaoeating.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppBasket {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/shiyaoeating/spring/test/beans/basketbean.xml");
        
        FruitBasket basket = (FruitBasket)context.getBean("fruitbasket");
        
        System.out.println(basket);
        
        ((ClassPathXmlApplicationContext)context).close();
    }
}
