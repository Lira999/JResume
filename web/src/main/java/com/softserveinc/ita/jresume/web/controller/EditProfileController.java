package com.softserveinc.ita.jresume.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.

SoftServeUserInformationService;
import com.softserveinc.ita.jresume.business.service.UserService;
import com.softserveinc.ita.jresume.common.entity.SoftServeUserInformation;
import com.softserveinc.ita.jresume.common.entity.User;

/**
 * Controller for edit profile.
 * 
 * @author Bohdan Khudoba
 *         
 */
@Controller
@RequestMapping(value = "editprofile")
public class EditProfileController {
    
    /**
     * SoftServeUserInformationService to operate with SoftServeUserInformation
     * objects.
     */
    @Autowired
    private SoftServeUserInformationService softServeUserInformationService;
    
    /** User service to operate with user objects. */
    @Autowired
    private UserService userService;
    
    /**
     * Edit profile page mapping.
     * 
     * @return editprofile page.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public final String editProfile() {
        return "editprofile";
    }
    
    /**
     * Controller for edit profile.
     * 
     * @param principal
     *            current spring security user, logged in system.
     * @param softServeUserInformation
     *            softServeUserInformation to be updated if exist, else to be
     *            created.
     */
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final void editProfile(final Principal principal,
            @RequestBody final SoftServeUserInformation
            
    softServeUserInformation) {
        User currentUser = userService.findByEmail(principal.getName());
        if (currentUser.getUserInformation() == null) {
            softServeUserInformationService.create(softServeUserInformation,
                    currentUser);
        } else {
            softServeUserInformationService.update(softServeUserInformation,
                    currentUser);
        }
    }
    
}
