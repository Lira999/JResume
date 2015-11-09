package com.softserveinc.ita.jresume.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.UserService;
import com.softserveinc.ita.jresume.common.dto.UserDTO;

/**
 * Controller for view profile.
 * 
 * @author Bohdan Khudoba.
 *         
 */
@Controller
@RequestMapping(value = "/viewprofile")
public class ViewProfileController {
    
    /** User service to operate with user objects. */
    @Autowired
    private UserService userService;
    
    /**
     * View profile page mapping.
     * 
     * @return viewprofile page.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public final String viewProfile() {
        return "viewprofile";
    }
    
    /**
     * Controller for find current user.
     * 
     * @param principal
     *            current spring security user, logged in system.
     * @return current user.
     */
    @RequestMapping(value = "/result", produces = "application/json",
            method = RequestMethod.GET)
    @ResponseBody
    public final UserDTO getUser(final Principal principal) {
        return userService.findDtoByEmail(principal.getName());
    }
}
