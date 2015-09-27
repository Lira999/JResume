package com.softserveinc.ita.jresume.web.controller;

import org.springframework.security.authentication.

InternalAuthenticationServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
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
     * @param webRequest
     *            current web request
     * @return modelAndView with "login" view and error message (if error
     *         present)
     */
    @SuppressWarnings("static-access")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public final ModelAndView login(final WebRequest webRequest,
            @RequestParam(value = "error",
                    required = false) final String error) {
        ModelAndView modelAndView = new ModelAndView();
        Object lastException =
                webRequest.getAttribute("SPRING_SECURITY_LAST_EXCEPTION",
                        webRequest.SCOPE_SESSION);
        if (error != null) {
            if (lastException
            
            instanceof InternalAuthenticationServiceException) {
                modelAndView.addObject("error",
                        "JResume encountered some internal problems. "
                                + "We working to resolve the issue as "
                                + "soon as possible."
                                + " Please try again later.");
            } else {
                modelAndView.addObject("error", "Incorect sign in data!");
            }
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
    
}
