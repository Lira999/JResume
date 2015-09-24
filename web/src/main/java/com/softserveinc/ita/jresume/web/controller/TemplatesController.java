package com.softserveinc.ita.jresume.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for templates page.
 * 
 * @author Ira Lialikova
 */
@Controller
public class TemplatesController {
    
    /**
     * Templates page mapping.
     * 
     * @return model "templates" view
     */
    @RequestMapping(value = "/templates", method = RequestMethod.GET)
    public final ModelAndView templates() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("templates");
        return modelAndView;
    }
    
}
