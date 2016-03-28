package com.beaverbay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beaverbay.bean.PersonBean;
import com.beaverbay.service.PersonService;

@Controller
public class PersonController {
    
    @Autowired
    PersonService personService;
    
    @RequestMapping(value = "/getPerson", method = RequestMethod.GET)
    public void getPerson() {
        PersonBean bean = personService.getPerson(1);
        
        System.out.println(bean);
    }
    
    @RequestMapping(value = "/getPersonById", method = RequestMethod.GET)
    public ModelAndView getPersonById() {
        PersonBean bean = personService.getPerson(1);
        
        System.out.println(bean);
        return new ModelAndView("person.jsp", "person", bean);
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createPerson(@ModelAttribute PersonBean personBean, Model model) {   
        personService.createPerson(personBean);
        
        model.addAttribute("personBean", personService.getPerson(1));
        return "result";
    }
}
