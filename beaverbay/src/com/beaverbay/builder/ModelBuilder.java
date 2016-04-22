package com.beaverbay.builder;

import java.util.Date;

import com.beaverbay.bean.UserBean;
import com.beaverbay.model.User;

public class ModelBuilder {

    public static User buildUserByBean(UserBean bean) {
        User user = new User();
        user.setEmail(bean.getEmail());
        user.setCreateDate(new Date());
        user.setPassword(bean.getPassword());
        
        return user;
    }
}
