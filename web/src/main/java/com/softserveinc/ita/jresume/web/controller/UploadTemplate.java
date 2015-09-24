package com.softserveinc.ita.jresume.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for view upload template page.
 * 
 */
@Controller
public class UploadTemplate {
    
    /**
     * Templates page mapping.
     
     * @return model "upload template" view
     */
    @RequestMapping(value = "/uploadtemplate", method = RequestMethod.GET)
    public final ModelAndView viewtempl() {
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("uploadtemplate");
        return modelAndView;
    
    }
}
