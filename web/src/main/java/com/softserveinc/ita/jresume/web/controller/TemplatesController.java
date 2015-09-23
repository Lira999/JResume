package com.softserveinc.ita.jresume.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
     * @param error
     *            Error message to display
     * @return model "templates" view
     */
    @RequestMapping(value = "/templates", method = RequestMethod.GET)
    public final ModelAndView templates(@RequestParam(value = "error",
            required = false) final String error) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Incorect sign in data!");
        }
        modelAndView.setViewName("templates");
        return modelAndView;
    }
    
}
