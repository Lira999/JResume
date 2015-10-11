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
     * Returns full user name (first name and last name) of current logged in
     * user. If system has no logged in user, returns {@code null}.
     * 
     * @param principal
     *            current spring security user, logged in system
     * @return current user's full name or {@code null} if system has no logged
     *         in user
     */
    @RequestMapping(value = "getCurrentUserFullName",
            method = RequestMethod.GET)
    @ResponseBody
    public final String getCurrentUserFullName(final Principal principal) {
        if (principal != null) {
            User currentUser = userService.findByEmail(principal.getName());
            return currentUser.getFirstName() + " "
                    + currentUser.getLastName();
        } else {
            return null;
        }
    }
    
}
