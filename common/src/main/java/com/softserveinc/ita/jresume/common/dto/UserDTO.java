package com.softserveinc.ita.jresume.common.dto;

/**
 * Data Transfer Object for User entity.
 * 
 * @author Bohdan Khudoba
 *         
 */
public class UserDTO extends BaseDTO {
    
    /** First name of this user. */
    private String firstName;
    
    /** Last name of this user. */
    private String lastName;
    
    /** Email of this user. */
    private String email;
    
    /** Password of this user. */
    private String password;
    
    /**
     * Gets the first name of this user.
     * 
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }
    
    /**
     * Changes the first name of this user.
     * 
     * @param newFirstName
     *            new first name to set
     */
    public final void setFirstName(final String newFirstName) {
        firstName = newFirstName;
    }
    
    /**
     * Gets the last name of this user.
     * 
     * @return the last name
     */
    public final String getLastName() {
        return lastName;
    }
    
    /**
     * Changes the last name of this user.
     * 
     * @param newLastName
     *            new first name to set
     */
    public final void setLastName(final String newLastName) {
        lastName = newLastName;
    }
    
    /**
     * Gets the email of this user.
     * 
     * @return the email
     */
    public final String getEmail() {
        return email;
    }
    
    /**
     * Changes the email of this user.
     * 
     * @param newEmail
     *            the email to set
     */
    public final void setEmail(final String newEmail) {
        email = newEmail;
    }
    
    /**
     * Gets the password of this user.
     * 
     * @return the password
     */
    public final String getPassword() {
        return password;
    }
    
    /**
     * Changes the user password.
     * 
     * @param newPassword
     *            the password to set
     */
    public final void setPassword(final String newPassword) {
        password = newPassword;
    }
    
}
