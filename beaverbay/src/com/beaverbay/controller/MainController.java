package com.beaverbay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.beaverbay.bean.UserBean;
import com.beaverbay.service.UserService;
import com.beaverbay.utility.UserException;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:/home";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String getLoginPage(HttpServletRequest request, ModelMap model,
            @RequestParam(value="failed", required=false, defaultValue="false") String error,  
            @RequestParam(value="logout", required=false, defaultValue="false") boolean logout) {
        
        model.addAttribute("userBean", new UserBean());
        
        return "login";
    }
    
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
