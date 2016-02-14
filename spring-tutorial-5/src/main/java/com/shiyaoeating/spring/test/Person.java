package com.shiyaoeating.spring.test;

public class Person {
	private int id;
	private String name;
	private int taxId;
	private Address address;
	
	public void setAddress(Address address) {
        this.address = address;
    }

    public Person() {
		
	}
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId + ", address=" + address + "]";
    }

	public void speak() {
		System.out.println("Hello! I'm a a person!");
	}
	
	public void onCreate() {
	    System.out.println("Person created: " + this);
	}
	
	public void onDestroy() {
	    System.out.println("Person destroyed: " + this);
	}
	
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

}
