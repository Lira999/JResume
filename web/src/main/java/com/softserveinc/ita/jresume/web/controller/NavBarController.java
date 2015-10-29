package com.softserveinc.ita.jresume.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.UserService;
import com.softserveinc.ita.jresume.common.entity.User;

/**
 * Controller for navigation bar.
 * 
 * @author Golovii Sergii
 *         
 */
@Controller
public class NavBarController {
    
    /**
     * User service to operate with user objects.
     */
    @Autowired
    private UserService userService;
    
    /**
     * Returns full user name (first name and last name) and role of current
     * logged in user. If system has no logged in user, returns {@code null}.
     * 
     * @param principal
     *            current spring security user, logged in system
     * @return array of 2 string elements, first contains current user full name
     *         and second - current user role. Returns {@code null} if system
     *         has no logged user
     */
    @RequestMapping(value = "getUserInformation",
            method = RequestMethod.GET)
    @ResponseBody
    public final String[] getUserInformation(final Principal principal) {
        String[] information = null;
        if (principal != null) {
            information = new String[2];
            User currentUser = userService.findByEmail(principal.getName());
            information[0] = currentUser.getFirstName() + " "
                    + currentUser.getLastName();
            information[1] = currentUser.getRole().toString();
        }
        return information;
    }
    
}
