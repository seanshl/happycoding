package com.beaverbay.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    protected BaseDao() {
    }
    
    public Session getSession()  {
        return sessionFactory.getCurrentSession();
    }
    
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory)  {
        this.sessionFactory = sessionFactory;
    }
    
    public void save(Object object) {
        getSession().saveOrUpdate(object);
    }
    
    public void delete(Object object) {
        getSession().delete(object);
    }
    
    
}
