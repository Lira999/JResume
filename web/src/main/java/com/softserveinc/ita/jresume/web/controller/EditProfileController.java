package com.softserveinc.ita.jresume.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.UserService;
import com.softserveinc.ita.jresume.common.dto.UserDTO;
import com.softserveinc.ita.jresume.common.entity.User;

/**
 * Controller for edit profile.
 * 
 * @author Bohdan Khudoba
 *         
 */
@Controller
public class EditProfileController {
    
    /** User service to operate with user objects. */
    @Autowired
    private UserService userService;
    
    /**
     * Edit profile page mapping.
     * 
     * @return editprofile page.
     */
    @RequestMapping(value = "editprofile", method = RequestMethod.GET)
    public final String editProfile() {
        return "editprofile";
    }
    
    /**
     * Controller for find current user.
     * 
     * @param principal
     *            current spring security user, logged in system.
     * @return current user.
     */
    @RequestMapping(value = "editprofile/result", produces = "application/json",
            method = RequestMethod.GET)
    @ResponseBody
    public final UserDTO getUser(final Principal principal) {
        return userService.findDtoByEmail(principal.getName());
    }
    
    /**
     * Controller for update User Profile.
     * 
     * @param principal
     *            current spring security user, logged in system.
     * @param updatedUser
     *            updated user profile.
     */
    @RequestMapping(value = "editprofile", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final void editProfile(final Principal principal,
            @RequestBody final UserDTO updatedUser) {
        User currentUser = userService.findByEmail(principal.getName());
        userService.update(currentUser, updatedUser);
    }
    
    /**
     * Controller for checking password matching.
     * 
     * @param password
     *            entered password.
     * @param principal
     *            current spring security user, logged in system.
     * @return true if password matching.
     */
    @RequestMapping(value = "currentPassword", method = RequestMethod.POST)
    @ResponseBody
    public final Boolean currentPasswordMath(@RequestBody final String password,
            final Principal principal) {
        return userService.findByEmail(principal.getName()).getPassword()
                .equals(password.replace("currentPassword=", ""));
    }
}
