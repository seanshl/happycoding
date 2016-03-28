package com.beaverbay.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.beaverbay.model.Person;

@Repository
public class PersonDao extends BaseDao {
    
    private static final String RETRIEVE_ALL_PERSON = "from Person ";  
    @SuppressWarnings("unchecked")
    public List <Person> retrieveAllPerson() {
        return getSession().createQuery(RETRIEVE_ALL_PERSON).list();
    }
    
    private static final String RETRIEVE_PERSON = "from Person where personId = :personId";
    public Person retrievePerson(long personId) {
        return (Person)getSession().createQuery(RETRIEVE_PERSON)
                .setLong("personId", personId).uniqueResult();
    }
    
    public void createPerson(Person person) {
        person.setCreateDate(new Date());
        person.setEditDate(new Date());
        
        super.save(person);
    }
}