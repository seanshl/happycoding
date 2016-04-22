package com.beaverbay.utility;


import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserInfo extends User {
    private static final long serialVersionUID = 1192091401956296780L;
    private long userId;
    private String email;
    private Collection <UserRole> authorities;

    @SuppressWarnings("unchecked")
    public UserInfo(String email, String password, Long userId, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        // TODO Auto-generated constructor stub
        this.email = email;
        this.userId = userId;
        this.authorities = (Collection<UserRole>) authorities;
    }
    
    public boolean isAuthenticated() {
        if (this.authorities == null || this.authorities.isEmpty()) {
            return false;
        } else {
           for (UserRole role : authorities) {
               if (StringUtils.isNotBlank(role.getAuthority())) {
                   return true;
               }
           }
        }
            
        return true;
    }
    
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}

