package com.softserveinc.ita.jresume.business.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.softserveinc.ita.jresume.business.service.UserService;
import com.softserveinc.ita.jresume.common.entity.User;

/**
 * Implementation of Validator interface for registration data validation.
 * 
 * @author Andriy Zykhor
 */
@Service
public class RegisterDataValidator implements Validator {
    
    /** Email regex pattern. */
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]+)$";
                    
    /** First name and last name regex pattern. */
    private static final String STRING_PATTERN =
            "^[A-Za-z][A-Za-z\\- ']*$";
            
    /** Variable for access to data storage. */
    @Autowired
    private UserService userService;
    
    @SuppressWarnings("rawtypes")
    @Override
    public final boolean supports(final Class clazz) {
        return User.class.isAssignableFrom(clazz);
    }
    
    @Override
    public final void validate(final Object target, final Errors errors) {
        User user = (User) target;
        
        // first name existing conatains characters only
        ValidationUtils.rejectIfEmpty(errors, "firstName", "required.fisrtName",
                "Name is required.");
        if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {
            Pattern pattern = Pattern.compile(STRING_PATTERN);
            Matcher matcher = pattern.matcher(user.getFirstName());
            if (!matcher.matches()) {
                errors.rejectValue("firstName", "firstName.containNonChar",
                        "Enter a valid first name");
            }
        }
        
        // last name required and conatains characters only
        ValidationUtils.rejectIfEmpty(errors, "lastName", "required.fisrtName",
                "Name is required.");
        if (user.getLastName() != null && !user.getLastName().isEmpty()) {
            Pattern pattern = Pattern.compile(STRING_PATTERN);
            Matcher matcher = pattern.matcher(user.getLastName());
            if (!matcher.matches()) {
                errors.rejectValue("lastName", "lastName.containNonChar",
                        "Enter a valid last name");
            }
        }
        
        // email validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "required.email", "Email is required.");
        if (!(user.getEmail() != null && user.getEmail().isEmpty())) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(user.getEmail());
            if (!matcher.matches()) {
                errors.rejectValue("email", "email.incorrect",
                        "Enter a correct email");
            }
        }
        
        // validation for existing email
        if (user.getEmail() != null && userService.findByEmail(user
                .getEmail()) != null) {
            errors.rejectValue("email", "email.incorrect",
                    "This email is already taken");
        }
    }
    
}
