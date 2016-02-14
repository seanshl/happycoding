package com.shiyaoeating.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shiyaoeating/spring/test/beans/beans.xml");
		
		//Person person = new Person();
		Person person = (Person)context.getBean("person");
		person.speak();
		((ClassPathXmlApplicationContext) context).close();
	}

}
