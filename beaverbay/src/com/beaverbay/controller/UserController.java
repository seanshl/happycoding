package com.beaverbay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beaverbay.bean.UserBean;
import com.beaverbay.service.UserService;
import com.beaverbay.utility.UserException;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String registerPerson(Model model) {
        model.addAttribute("userBean", new UserBean());
        
        return "register";
    }
    
    @RequestMapping(value="register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute UserBean userBean, Model model) {
        if (userService.getUserByEmail(userBean.getEmail()) != null) {
            model.addAttribute("failed", "User already existed.");
            
            return "register";
        }
        
        try {
            userService.createUser(userBean);
        } catch (UserException e) {
            model.addAttribute("failed", e.getMessage());
            
            return "register";          
        }
        
        return "redirect:home";
    }
}
