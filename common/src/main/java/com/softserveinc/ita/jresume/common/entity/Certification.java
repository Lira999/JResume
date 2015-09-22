package com.softserveinc.ita.jresume.common.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;

/**
 * This class describes Certification entity which stores the information about
 * certificated which were gained by a developer.
 * 
 * This Certification entity has a many to one relationship with the
 * UserInformation entity.
 * 
 * @author Andriy Luchko
 */
@Entity
@Table(name = "certification")
public class Certification extends Base {
    
    /**
     * Describes the name of a certificate.
     */
    @Column(name = "name")
    private String name;
    
    /**
     * Describes the year when the certificate was gained.
     */
    @Column(name = "yearReceived")
    private Short yearReceived;
    
    /**
     * Stores a reference to a logo of a certificate.
     */
    @Column(name = "logo")
    private byte[] logo;
    
    /**
     * Certification associates with UserInformation. Many to one relationship,
     * references to usetInformation table
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usetInformationId")
    private UserInformation userInformation;

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
    public final void setYearReceived(
            final Short newYearReceived) {
        yearReceived = newYearReceived;
    }
    
    /**
     * Sets the reference to the lofo of a certificate.
     * 
     * @param newLogo
     *            the byte array which represents a logo
     */
    public final void setLogo(final byte[] newLogo) {
        logo = newLogo;
    }
    
    /**
     * Changes information about user, associated with this certification gained
     * by user.
     * 
     * @param newUserInformation
     *            information about user.
     */
    public final void setUserInformation(
            final UserInformation newUserInformation) {
        userInformation = newUserInformation;
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
     * @return the byte array of the logo
     */
    public final byte[] getLogo() {
        return logo;
    }
    
    /**
     * Gets information about user associated with the certificate gained by
     * user.
     * 
     * @return information about user associated with the certificate.
     */
    public final UserInformation getUserInformation() {
        return userInformation;
    }
    
}
