package com.beaverbay.bean;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.beaverbay.model.User;

public class UserBean implements Bean{
    private Long id;
    private String email;
    private String username;
    private String password;
    private Date createDate;
    
    @Override
    public boolean isValidForModel() {
        boolean isValid = true;
        if (StringUtils.isBlank(this.email) || StringUtils.isBlank(this.password)) {
            isValid = false;
        }
        
        return isValid;
    }
    
    public UserBean() {};
    
    public UserBean(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.createDate = user.getCreateDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    
}
