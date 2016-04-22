package com.beaverbay.service;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beaverbay.model.User;
import com.beaverbay.utility.UserInfo;
import com.beaverbay.utility.UserRole;

/**
 * 
 * This class is a functional interface implementation for Spring Security,
 * the only method will be used for Spring Security to do the authentication. 
 *
 */
@Service("loginService")
public class LoginService implements UserDetailsService {
    @Autowired
    private com.beaverbay.dao.UserDao userDao;
    
/*    public static final String ROLE_STANDARD = "ROLE_STD";
    public static final String ROLE_MANAGER = "ROLE_MANAGER";*/
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (StringUtils.isBlank(email)) {
            throw new UsernameNotFoundException("No valid email provided");
        }
        
        User user = userDao.retrieveUserByEmail(email);
        
        if (user == null) {
            throw new UsernameNotFoundException("Username doesn't exist");
        }
        
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority> ();
        UserRole role = new UserRole("ROLE_USER");
        
        authorities.add(role);
        
        UserInfo ui = new UserInfo(user.getEmail(), 
                user.getPassword(), 
                user.getId(), 
                authorities);
        
        return ui;
    }
    

}
