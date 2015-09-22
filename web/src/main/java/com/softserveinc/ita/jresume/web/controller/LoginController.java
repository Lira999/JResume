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
     * Login page mapping.
     * 
     * @param error
     *            Error message to display
     * @return model "login" view
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public final ModelAndView login(@RequestParam(value = "error",
            required = false) final String error) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Incorect sign in data!");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
    
}
