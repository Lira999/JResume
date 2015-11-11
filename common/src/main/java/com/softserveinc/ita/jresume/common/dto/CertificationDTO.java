package com.softserveinc.ita.jresume.common.dto;

/**
 * Data Transfer Object for Certification entity.
 * 
 * @author Bohdan Khudoba.
 * 
 */
public class CertificationDTO extends BaseDTO {
    
    /**
     * Certification Id.
     */
    private Long id;
    
    /**
     * Describes the name of a certificate.
     */
    private String name;
    
    /**
     * Describes the year when the certificate was gained.
     */
    private Short yearReceived;
    
    /**
     * Stores a reference to a logo of a certificate.
     */
    private byte[] logo;
    
    /**
     * Id associated with UserInformation.
     */
    private Long userInformationId;
    
    /**
     * Gets userInformationId.
     * 
     * @return userInformationId.
     */
    public final Long getUserInformationId() {
        return userInformationId;
    }
    
    /**
     * Changes userInformationId.
     * 
     * @param newUserInformationId
     *            new userInformationId.
     */
    public final void setUserInformationId(final Long newUserInformationId) {
        userInformationId = newUserInformationId;
    }
    
    /**
     * Sets the certificates name.
     * 
     * @param newName
     *            name of a certificate to set
     */
    public final void setName(final String newName) {
        name = newName;
    }
    
    /**
     * Sets the year when certificate was received.
     * 
     * @param newYearReceived
     *            a year when developer got a certificate
     */
    public final void setYearReceived(final Short newYearReceived) {
        yearReceived = newYearReceived;
    }
    
    /**
     * Sets the reference to the logo of a certificate.
     * 
     * @param newLogo
     *            the byte array which represents a logo
     */
    public final void setLogo(final byte[] newLogo) {
        logo = newLogo;
    }
    
    /**
     * Get value of field certificationName.
     * 
     * @return the name of a certificate
     */
    public final String getName() {
        return name;
    }
    
    /**
     * Get value of field yearReceived.
     * 
     * @return the year where certificate was gained
     */
    public final Short getYearReceived() {
        return yearReceived;
    }
    
    /**
     * Get value of field certificationLogo.
     * 
     * @return the byte array of the logo.
     */
    public final byte[] getLogo() {
        return logo;
    }
    
    /**
     * Get value of id.
     * 
     * @return id of this Certification.
     */
    public final Long getId() {
        return id;
    }
    
    /**
     * Change value of this id.
     * 
     * @param newId
     *            id of this Certification to be changed.
     */
    public final void setId(final Long newId) {
        id = newId;
    }
}
