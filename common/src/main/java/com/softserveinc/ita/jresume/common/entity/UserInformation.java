package com.softserveinc.ita.jresume.common.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Describe UserInformation entity class.
 * 
 * @author Bohdan Khudoba
 */
@XmlRootElement(name = "userInformation")
@Entity
@Table(name = "userInformation")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserInformation extends Base {
    
    /** Column for first name. */
    @XmlElement
    @Column(name = "firstName")
    private String firstName;
    
    /** Column for last name. */
    @XmlElement
    @Column(name = "lastName")
    private String lastName;
    
    /** Column for birth date. */
    @XmlElement
    @Temporal(TemporalType.DATE)
    @Column(name = "birthDate")
    private Date birthDate;
    
    /** Column for position. */
    @XmlElement
    @Column(name = "position")
    private String position;
    
    /** Column for summary. */
    @XmlElement(name = "summary")
    @Column(name = "summary")
    private String summary;
    
    /**
     * user associated with this userInformation. One to one relationship,
     * references to user table.
     */
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
    
    /**
     * All projects associated with information about this user. One to many
     * relationship references with mark table.
     */
    @XmlElements({ @XmlElement(name = "project", type = Project.class), })
    @XmlElementWrapper(name = "projects")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userInformation")
    private List<Project> projects;
    
    /**
     * All information about user's education are linked with information about
     * this user. One to many relationship references with mark table.
     */
    @XmlElements({ @XmlElement(name = "education", type = Education.class), })
    @XmlElementWrapper(name = "educations")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userInformation")
    private List<Education> education;
    
    /**
     * All certifications of user are associated with information about this
     * user. One to many relationship references with mark table.
     */
    @XmlElements({ @XmlElement(name = "certification",
            type = Certification.class), })
    @XmlElementWrapper(name = "certifications")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userInformation")
    private List<Certification> certification;
    
    /** One to one relationship with SoftServeUserInformation. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userInformation",
            cascade = CascadeType.ALL)
    private SoftServeUserInformation softServeUserInformation;
    
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
     * Get value of column user.
     * 
     * @return the user
     */
    public final User getUser() {
        return user;
    }
    
    /**
     * Changes user value of this User.
     * 
     * @param newUser
     *            this user new value
     */
    public final void setUser(final User newUser) {
        user = newUser;
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
     * Changes list with all certificates associated with this user.
     * 
     * @param newCertification
     *            list with certification information for this user
     */
    public final void setCertification(
            final List<Certification> newCertification) {
        certification = newCertification;
    }
    
    /**
     * Gets the SoftServeUserInformation associated with this userInformation.
     * 
     * @return the softServeUserInformation.
     */
    public final SoftServeUserInformation getSoftServeUserInformation() {
        return softServeUserInformation;
    }
    
    /**
     * Changes the SoftServeUserInformation associated with this
     * userInformation.
     * 
     * @param newSoftServeUserInformation
     *            new SoftServeUserInformation to set.
     */
    public final void
            setSoftServeUserInformation(
                    final SoftServeUserInformation
                    
    newSoftServeUserInformation) {
        softServeUserInformation = newSoftServeUserInformation;
    }
    
    /**
     * Gets the instance of UserInformation.
     * 
     * @return object of UserInformation.
     */
    public final UserInformation getInstance() {
        return this;
    }
    
}
