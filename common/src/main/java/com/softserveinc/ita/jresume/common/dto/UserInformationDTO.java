package com.softserveinc.ita.jresume.common.dto;

import java.util.Date;
import java.util.List;

/**
 * Data Transfer Object for UserInformation entity.
 * 
 * @author Bohdan Khudoba.
 *         
 */
public class UserInformationDTO extends BaseDTO {
    
    /**
     * UserInformation Id.
     */
    private Long id;
    
    /**
     * Value of First Name.
     */
    private String firstName;
    
    /**
     * Value of Last Name.
     */
    private String lastName;
    
    /**
     * Value of Birth Date.
     */
    private Date birthDate;
    
    /**
     * Value of position.
     */
    private String position;
    
    /**
     * Value of summary.
     */
    private String summary;
    
    /**
     * List with Certifications Id.
     */
    private List<Long> listOfCetificationId;
    
    /**
     * List with Educations Id.
     */
    private List<Long> listOfEducationId;
    
    /**
     * List with Projects Id.
     */
    private List<Long> listOfProjectId;
    
    /**
     * Get value of firstName.
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
     * Get value of lastName.
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
     * Get value of birthDate.
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
     * Get value of position.
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
     * Get value of summary.
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
     * Get value of id.
     * 
     * @return id of this UserInformation.
     */
    public final Long getId() {
        return id;
    }
    
    /**
     * Change value of this id.
     * 
     * @param newId
     *            id of this UserInformation to be changed.
     */
    public final void setId(final Long newId) {
        id = newId;
    }
    
    /**
     * Get list with certifications id.
     * 
     * @return listOfCetificationId.
     */
    public final List<Long> getListOfCetificationId() {
        return listOfCetificationId;
    }
    
    /**
     * Change list with certifications id.
     * 
     * @param newListOfCetificationId
     *            new list with certifications id to be changed.
     */
    public final void
            setListOfCetificationId(final List<Long> newListOfCetificationId) {
        listOfCetificationId = newListOfCetificationId;
    }
    
    /**
     * Get list with educations id.
     * 
     * @return listOfEducationId.
     */
    public final List<Long> getListOfEducationId() {
        return listOfEducationId;
    }
    
    /**
     * Change list with educations id.
     * 
     * @param newListOfEducationId
     *            new list with educations id to be changed.
     */
    public final void
            setListOfEducationId(final List<Long> newListOfEducationId) {
        listOfEducationId = newListOfEducationId;
    }
    
    /**
     * Get list with projects id.
     * 
     * @return listOfProjectId.
     */
    public final List<Long> getListOfProjectId() {
        return listOfProjectId;
    }
    
    /**
     * Change list with projects id.
     * 
     * @param newListOfProjectId
     *            new list with projects id to be changed.
     */
    public final void setListOfProjectId(final List<Long> newListOfProjectId) {
        listOfProjectId = newListOfProjectId;
    }
    
}
