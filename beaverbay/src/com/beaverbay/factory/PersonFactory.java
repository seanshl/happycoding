package com.beaverbay.factory;

import com.beaverbay.bean.PersonBean;
import com.beaverbay.model.Person;

public class PersonFactory implements IFactory {

    public static Person create(PersonBean bean) {
        // TODO Auto-generated method stub
        if (bean == null) {
            return null;
        }
        
        Person person = new Person();
        person.setFirstName(bean.getFirstName());
        person.setLastName(bean.getLastName());
        person.setUserName(bean.getUserName());
        person.setEmail(bean.getEmail());
        person.setPhone(bean.getPhone());
        person.setGender(bean.getGender());
        person.setOccupation(bean.getOccupation());
        person.setPassword(bean.getPassword());
        person.setBirthDate(bean.getBirthDate());
        
        return person;
    }
    
   

}
