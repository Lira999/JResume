package com.softserveinc.ita.jresume.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.UserService;
import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.common.entity.UserRole;

/**
 * Controller for registration process.
 * 
 * @author Andriy Zykhor
 */
@Controller
public class RegisterController {
    
    /** Variable for access to data storage. */
    @Autowired
    private UserService userService;
    
    /** Validator for validate registration data. */
    @Autowired
    private Validator validator;
    
    /**
     * Registration page mapping.
     * 
     * @return register view.
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public final String register() {
        return "register";
    }
    
    /**
     * Controller for validate registration data and create the new user.
     * 
     * @param user
     *            the user to be created.
     * @param result
     *            for validation errors.
     * @return status and message about registration process.
     */
    @RequestMapping(value = "register", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final Map<String, String> processRegistration(
            @RequestBody final User user, final BindingResult result) {
            
        validator.validate(user, result);
        
        Map<String, String> map = new HashMap<String, String>();
        if (result.hasErrors()) {
            map.put("status", "error");
            map.put("message", "Registration data invalid.");
        } else {
            user.setRole(UserRole.ROLE_USER);
            userService.create(user);
            map.put("status", "success");
            map.put("message", "");
        }
        return map;
    }
    
    /**
     * Controller for checking email existing.
     * 
     * @param email
     *            the email address of user.
     * @return true if email is not existing.
     */
    @RequestMapping(value = "register&emailExist", method = RequestMethod.POST)
    @ResponseBody
    public final String emailExisting(final String email) {
        if (userService.findByEmail(email) == null) {
            return "true";
        }
        return "false";
    }
    
}
