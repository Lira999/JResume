package com.softserveinc.ita.jresume.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for view template page.
 * 
 */
@Controller
public class ViewtemplController {
    
    /**
     * Templates page mapping.
     
     *            Error message to display
     * @return model "viewtempl" view
     */
    @RequestMapping(value = "/viewtempl", method = RequestMethod.GET)
    public final ModelAndView viewtempl() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewtempl");
        return modelAndView;
    }
    
}
