package com.softserveinc.ita.jresume.web.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.

UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.UserService;
import com.softserveinc.ita.jresume.business.validator.RegisterDataValidator;
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
    private RegisterDataValidator registerValidator;
    
    /** AuthenticationManager instance to log user to system. */
    @Autowired
    private AuthenticationManager authenticationManager;
    
    /** BCrypt password encoder. */
    @Autowired
    private BCryptPasswordEncoder encoder;
    
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
     * @param request
     *            current request information.
     * @return ResponseEntity that contains information about registration
     *         process.
     * @throws URISyntaxException
     *             if invalid URI syntax.
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public final ResponseEntity<String> processRegistration(
            @RequestBody final User user, final BindingResult result,
            final HttpServletRequest request)
                    throws URISyntaxException {
                    
        registerValidator.validate(user, result);
        
        String msg = "";
        HttpHeaders header = new HttpHeaders();
        HttpStatus status;
        
        if (result.hasErrors()) {
            msg = "Registration data invalid!";
            status = HttpStatus.BAD_REQUEST;
        } else {
            header.setLocation(new URI("templates"));
            status = HttpStatus.CREATED;
            user.setRole(UserRole.ROLE_USER);
            String rawPassword = user.getPassword();
            user.setPassword(encoder.encode(user.getPassword()));
            userService.create(user);
            authentificate(user.getEmail(), rawPassword, request);
        }
        return new ResponseEntity<String>(msg, header, status);
    }
    
    /**
     * Authenticate user to system using email and not encoded password.
     * 
     * @param email
     *            user's email
     * @param password
     *            user's password
     * @param request
     *            information about current request
     */
    private void authentificate(final String email, final String password,
            final HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(email, password);
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser =
                authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
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
    public final Boolean emailExisting(final String email) {
        return userService.findByEmail(email) == null;
    }
}
