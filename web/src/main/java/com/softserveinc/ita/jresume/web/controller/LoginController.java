package com.softserveinc.ita.jresume.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for login page.
 * 
 * @author Golovii Sergii
 */
@Controller
public class LoginController {
    
    /**
     * Login page mapping.
     * @return model "login" view
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public final ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }
    
}
