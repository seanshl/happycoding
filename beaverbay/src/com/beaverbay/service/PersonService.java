package com.beaverbay.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beaverbay.bean.PersonBean;
import com.beaverbay.dao.PersonDao;
import com.beaverbay.factory.PersonFactory;
import com.beaverbay.model.Person;

@Service
public class PersonService {
    
    @Autowired
    private PersonDao personDao;
    
    @Transactional
    public PersonBean getPerson(long personId) {
        Person person = personDao.retrievePerson(personId);
        PersonBean bean = new PersonBean(person);
        
        return bean;
    }
    
    @Transactional
    public void createPerson(PersonBean bean) {
        Person person = PersonFactory.create(bean);
        
        person.setCreateDate(new Date());
        person.setEditDate(new Date());
        person.setLastLogin(new Date());
        
        personDao.save(person);
    }
}
