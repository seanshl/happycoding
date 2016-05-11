package com.beaverbay.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beaverbay.bean.UserBean;
import com.beaverbay.builder.ModelBuilder;
import com.beaverbay.dao.UserDao;
import com.beaverbay.model.User;
import com.beaverbay.utility.UserException;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    
    private static final Logger logger = Logger.getLogger(UserService.class);
    
    @Transactional
    public User getUserByEmail(String email) {
        User user = userDao.retrieveUserByEmail(email);
        
        return user;
    }
    
    @Transactional
    public void createUser(UserBean bean) throws UserException{   
        if (!bean.isValidForModel()) {
            throw new UserException("There're missing field in the form, please verify.");
        }

        //I will consider move the defaultEditUser to userDao if this is frequently used.
        bean.setPassword(BCrypt.hashpw(bean.getPassword().trim(), BCrypt.gensalt()));
        User user = ModelBuilder.buildUserByBean(bean);        
        
        try {
            userDao.save(user);
            
            logger.info("User created at: " + new Date() + "\n User Details" + user.toString() );
        } catch (Exception e) {
            String message = "There's an error creating user: \n" + bean.toString();
            logger.error(message, e);
            throw new UserException(message);
        }
    }
}
