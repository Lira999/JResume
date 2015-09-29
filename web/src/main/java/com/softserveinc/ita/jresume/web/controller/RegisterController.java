package com.softserveinc.ita.jresume.web.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @return ResponseEntity that contains information about registration
     *         process.
     * @throws URISyntaxException
     *             if invalid URI syntax.
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public final ResponseEntity<String> processRegistration(
            @RequestBody final User user, final BindingResult result)
                    throws URISyntaxException {
                    
        validator.validate(user, result);
        
        String msg;
        HttpHeaders header = new HttpHeaders();
        HttpStatus status;
        
        if (result.hasErrors()) {
            msg = "Registration data invalid!";
            status = HttpStatus.UNPROCESSABLE_ENTITY;
        } else {
            msg = "{}";
            header.setLocation(new URI("login"));
            status = HttpStatus.CREATED;
            user.setRole(UserRole.ROLE_USER);
            userService.create(user);
        }
        
        return new ResponseEntity<String>(msg, header, status);
    }
    
    /**
     * Controller for checking email existing.
     * 
     * @param email
     *            the email address of user.
     * @return true if email is not existing.
     */
    @RequestMapping(value = "emailExist", method = RequestMethod.POST)
    @ResponseBody
    public final String emailExisting(final String email) {
        return Boolean.toString(userService.findByEmail(email) == null);
    }
}
