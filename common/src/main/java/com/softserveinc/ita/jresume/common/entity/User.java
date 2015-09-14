package com.softserveinc.ita.jresume.common.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Describe User entity class.
 * 
 * @author Andriy Zykhor
 */
@Entity
@Table(name = "user")
public class User extends Base {
    
    /** Column for first name. */
    @Column(name = "firstName")
    private String firstName;
    
    /** Column for last name. */
    @Column(name = "lastName")
    private String lastName;
    
    /** Column for email. */
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    /** Column for password. */
    @Column(name = "password", nullable = false)
    private String password;
    
    /** Column for role. */
    @Column(name = "role", nullable = false)
    private String role;
    
    /** One to many relationship with table ordering. */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Ordering> orderings;
    
    /**
     * Public constructor for class Base.
     */
    public User() {
        super();
    }
    
    /**
     * Get value of column firstName.
     * 
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }
    
    /**
     * @param newFirstName
     *            the firstName to set
     */
    public final void setFirstName(final String newFirstName) {
        firstName = newFirstName;
    }
    
    /**
     * Get value of column lastName.
     * 
     * @return the lastName
     */
    public final String getLastName() {
        return lastName;
    }
    
    /**
     * @param newLastName
     *            the lastName to set
     */
    public final void setLastName(final String newLastName) {
        lastName = newLastName;
    }
    
    /**
     * Get value of column email.
     * 
     * @return the email
     */
    public final String getEmail() {
        return email;
    }
    
    /**
     * @param newEmail
     *            the email to set
     */
    public final void setEmail(final String newEmail) {
        email = newEmail;
    }
    
    /**
     * Get value of column password.
     * 
     * @return the password
     */
    public final String getPassword() {
        return password;
    }
    
    /**
     * @param newPassword
     *            the password to set
     */
    public final void setPassword(final String newPassword) {
        password = newPassword;
    }
    
    /**
     * Get value of column role.
     * 
     * @return the role
     */
    public final String getRole() {
        return role;
    }
    
    /**
     * @param newRole
     *            the role to set
     */
    public final void setRole(final String newRole) {
        role = newRole;
    }
    
    /**
     * Get orderings list.
     * 
     * @return list with all orderings associated with this user.
     */
    public final List<Ordering> getOrderings() {
        return orderings;
    }
    
    /**
     * Changes list with all orderings associated with this user.
     * 
     * @param newOrderings
     *            new orderings list
     */
    public final void setOrderings(final List<Ordering> newOrderings) {
        orderings = newOrderings;
    }
}
