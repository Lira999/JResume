package com.softserveinc.ita.jresume.common.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Describe User entity class.
 * 
 * @author Andriy Zykhor
 */
@Entity
@Table(name = "user")
public class User extends Base {
    
    /** First name of this user. */
    @Column(name = "firstName")
    private String firstName;
    
    /** Last name of this user. */
    @Column(name = "lastName")
    private String lastName;
    
    /** Email of this user. */
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    /** Password of this user. */
    @Column(name = "password", nullable = false)
    private String password;
    
    /** Role of this user. */
    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "enum('ROLE_ADMIN','ROLE_USER')")
    private UserRole role;
    
    /** One to many relationship with Ordering. */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Ordering> orderings;
    
    /** One to many relationship with UserResume. */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserResume> userResumes;
    
    /** One to one relationship with UserInformation. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private UserInformation userInformation;
    
    /** One to many relationship with table mark. */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Mark> marks;
    
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
    
    /**
     * Get role of the user.
     * 
     * @return the role
     */
    public final UserRole getRole() {
        return role;
    }
    
    /**
     * Changes the user role.
     * 
     * @param newRole
     *            the role to set
     */
    public final void setRole(final UserRole newRole) {
        role = newRole;
    }
    
    /**
     * Get orderings list.
     * 
     * @return list with all orderings associated with this user
     */
    public final List<Ordering> getOrderings() {
        return orderings;
    }
    
    /**
     * Changes list with all orderings associated with this user.
     * 
     * @param newOrderings
     *            new orderings list to set
     */
    public final void setOrderings(final List<Ordering> newOrderings) {
        orderings = newOrderings;
    }
    
    /**
     * Get user resumes list.
     * 
     * @return list with all usersResumes associated with this user
     */
    public final List<UserResume> getUserResumes() {
        return userResumes;
    }
    
    /**
     * Changes list with all user resumes associated with this user.
     * 
     * @param newUserResumes
     *            new userResumes list to set
     */
    public final void setUserResumes(final List<UserResume> newUserResumes) {
        userResumes = newUserResumes;
    }
    
    /**
     * Gets the information associated with this user.
     * 
     * @return the userInformation
     */
    public final UserInformation getUserInformation() {
        return userInformation;
    }
    
    /**
     * Changes the information associated with this user.
     * 
     * @param newUserInformation
     *            new userInformation to set
     */
    public final void
            setUserInformation(final UserInformation newUserInformation) {
        userInformation = newUserInformation;
    }
    
    /**
     * Gets list of marks associated with this user.
     * 
     * @return the marks
     */
    public final List<Mark> getMarks() {
        return marks;
    }
    
    /**
     * Changes list of marks associated with this user.
     * 
     * @param newMarks
     *            new user marks to set
     */
    public final void setMarks(final List<Mark> newMarks) {
        marks = newMarks;
    }
    
}
