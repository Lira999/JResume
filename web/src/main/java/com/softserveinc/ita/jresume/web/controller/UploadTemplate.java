package com.softserveinc.ita.jresume.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for view upload template page.
 * 
 */
@Controller
public class UploadTemplate {
    
    /**
     * Templates page mapping.
     * 
     * @param error
     *            Error message to display
     * @return model "upload template" view
     */
    @RequestMapping(value = "/uploadtemplate", method = RequestMethod.GET)
    public final ModelAndView viewtempl(@RequestParam(value = "error",
            required = false) final String error) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Incorect sign in data!");
        }
        modelAndView.setViewName("uploadtemplate");
        return modelAndView;
    }
    
}
