package com.softserveinc.ita.jresume.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for index page.
 * 
 * @author Golovii Sergii
 *        
 */
@Controller
public class IndexController {
    
    /**
     * Index page mapping.
     * 
     * @return index page
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public final String getIndexPage() {
        return "index";
    }
    
}
