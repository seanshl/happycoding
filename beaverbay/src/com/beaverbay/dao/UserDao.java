package com.beaverbay.dao;

import org.springframework.stereotype.Repository;

import com.beaverbay.model.User;

@Repository
public class UserDao extends BaseDao {
    
    private static final String RETRIEVE_USER_BY_EMAIL = 
            "from User " +
            " where email = :email";
    public User retrieveUserByEmail(String email) {
        return (User)getSession().createQuery(RETRIEVE_USER_BY_EMAIL)
                .setString("email", email)
                .uniqueResult();
    }
    
    private static final String RETRIEVE_USER = 
            "from User " +
            " where id = :id";
    public User retrieveUser(Long id) {
        return (User)getSession().createQuery(RETRIEVE_USER)
                .setLong("id", id)
                .uniqueResult();
    }
}