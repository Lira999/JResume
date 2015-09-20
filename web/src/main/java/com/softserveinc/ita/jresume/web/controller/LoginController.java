package com.softserveinc.ita.jresume.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for login page.
 * 
 * @author Golovii Sergii
 */
@Controller
public class LoginController {
    
    /**
     * Login page with ability to display error messages on it.
     * @param error error message for page
     * @return model "login" view
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public final ModelAndView login(
            @RequestParam(value = "error",
                    required = false) final String error) {
                    
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Incorect sign in data!");
        }
        model.setViewName("login");
        
        return model;
    }
    
}
