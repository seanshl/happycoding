package com.shiyaoeating.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {

    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/shiyaoeating/spring/test/beans/beans.xml");
        
        Logger logger = (Logger)context.getBean("logger");
        
        logger.writeConsole("Hello there");
        logger.writeFile("Hi again");
        
        ((ClassPathXmlApplicationContext)context).close();
    }

}