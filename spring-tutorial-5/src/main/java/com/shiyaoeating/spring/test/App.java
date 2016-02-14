package com.shiyaoeating.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shiyaoeating/spring/test/beans/beans.xml");
		
		//Person person = new Person();
		Person person1 = (Person)context.getBean("person");
		person1.speak();
		
		Person person2 = (Person)context.getBean("person");
        person2.speak();
		
        person1.setTaxId(666);
        
		Address address = (Address) context.getBean("address");
		
		
		System.out.println(person1);
		System.out.println(person2);
		((ClassPathXmlApplicationContext) context).close();
	}

}
