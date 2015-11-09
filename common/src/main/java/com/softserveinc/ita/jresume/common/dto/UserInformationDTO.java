package com.softserveinc.ita.jresume.common.dto;

import java.util.Date;

/**
 * Data Transfer Object for UserInformation entity.
 * 
 * @author Bohdan Khudoba.
 * 
 */
public class UserInformationDTO extends BaseDTO {
    
    /** Value of First Name. */
    private String firstName;
    
    /** Value of Last Name. */
    private String lastName;
    
    /** Value of. */
    private Date birthDate;
    
    /** Value of position. */
    private String position;
    
    /** Value of summary. */
    private String summary;
    
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
}
