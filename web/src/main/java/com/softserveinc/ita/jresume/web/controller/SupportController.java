package com.softserveinc.ita.jresume.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for support page.
 * 
 * @author Golovii Sergii
 *        
 */
@Controller
public class SupportController {
    
    /**
     * support page mapping.
     * 
     * @return support view.
     */
    @RequestMapping(value = "support")
    public final String getSupportPage() {
        return "support";
    }
    
}
