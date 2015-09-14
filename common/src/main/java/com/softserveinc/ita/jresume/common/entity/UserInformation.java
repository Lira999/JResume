package com.softserveinc.ita.jresume.common.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Describe UserInformation entity class.
 * 
 * @author Bohdan Khudoba
 */
@Entity
@Table(name = "userInformation")
public class UserInformation extends Base {
    
    /** Column for first name. */
    @Column(name = "firstName")
    private String firstName;
    
    /** Column for last name. */
    @Column(name = "lastName")
    private String lastName;
    
    /** Column for birth date. */
    @Column(name = "birthDate")
    private Date birthDate;
    
    /** Column for position. */
    @Column(name = "position")
    private String position;
    
    /** Column for summary. */
    @Column(name = "summary")
    private String summary;
    
    /**
     * user associated with this userInformation. One to one relationship,
     * references to user table.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    
    /**
     * All projects associated with information about this user. One to many
     * relationship references with mark table.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userInformation")
    private List<Project> projects;
    
    /**
     * All information about user's education are linked with information about
     * this user. One to many relationship references with mark table.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userInformation")
    private List<Education> education;
    
    /**
     * All certifications of user are associated with information about this
     * user. One to many relationship references with mark table.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userInformation")
    private List<Certification> certification;
    
    /**
     * Public constructor for class UserInformation.
     */
    public UserInformation() {
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
     * Changes firstName value of this First Name.
     * 
     * @param newFirstName
     *            this first name new value
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
     * Changes lastName value of this Last Name.
     * 
     * @param newLastName
     *            this last name new value
     */
    public final void setLastName(final String newLastName) {
        lastName = newLastName;
    }
    
    /**
     * Get value of column birthDate.
     * 
     * @return the birthDate
     */
    public final Date getBirthDate() {
        return birthDate;
    }
    
    /**
     * Changes birthDate value of this Birth Date.
     * 
     * @param newBirthDate
     *            this birth date new value
     */
    public final void setBirthDate(final Date newBirthDate) {
        birthDate = newBirthDate;
    }
    
    /**
     * Get value of column position.
     * 
     * @return the position
     */
    public final String getPosition() {
        return position;
    }
    
    /**
     * Changes position value of this Position.
     * 
     * @param newPosition
     *            this position new value
     */
    public final void setPosition(final String newPosition) {
        position = newPosition;
    }
    
    /**
     * Get value of column summary.
     * 
     * @return the summary
     */
    public final String getSummary() {
        return summary;
    }
    
    /**
     * Changes summary value of this Summary.
     * 
     * @param newSummary
     *            this summary new value
     */
    public final void setSummary(final String newSummary) {
        summary = newSummary;
    }
    
    /**
     * Gets all projects associated with this user.
     * 
     * @return list with all projects associated with a user
     */
    public final List<Project> getProjects() {
        return projects;
    }
    
    /**
     * Changes list with all projects associated with this user.
     * 
     * @param newProjects
     *            list with projects for this user
     */
    public final void setProjects(final List<Project> newProjects) {
        projects = newProjects;
    }
    
    /**
     * Gets all education information associated with this user.
     * 
     * @return list with all education information associated with a user
     */
    public final List<Education> getEducation() {
        return education;
    }
    
    /**
     * Changes list with all education information associated with this user.
     * 
     * @param newEducation
     *            list with education information for this user
     */
    public final void setEducation(final List<Education> newEducation) {
        education = newEducation;
    }
    
    /**
     * Gets all certificates associated with this user.
     * 
     * @return list with all certificates associated with a user
     */
    public final List<Certification> getCertification() {
        return certification;
    }
    
    /**
     * Changes list with all certificates associated with
     * this user.
     * 
     * @param newCertification
     *            list with certification information for this user
     */
    public final void setCertification(
            final List<Certification> newCertification) {
        certification = newCertification;
    }
}
