package com.softserveinc.ita.jresume.common.entity;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @Column(name = "certificationName")
    private String certificationName;
    
    /**
     * Describes the year when the certificate was gained.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "yearReceived")
    private Calendar yearReceived;
    
    /**
     * Stores a reference to a logo of a certificate.
     */
    @Column(name = "certificationLogo")
    private byte[] certificationLogo;
    
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
     * @param newCertificationName
     *            name of a certificate to set
     */
    public final void setCertificationName(final String newCertificationName) {
        certificationName = newCertificationName;
    }
    
    /**
     * Sets the year when certificate was received.
     * 
     * @param newYearReceived
     *            a year when developer got a certificate
     */
    public final void setYearReceived(
            final Calendar newYearReceived) {
        yearReceived = newYearReceived;
    }
    
    /**
     * Sets the reference to the lofo of a certificate.
     * 
     * @param newCertificationLogo
     *            the byte array which represents a logo
     */
    public final void setCertificationLogo(final byte[] newCertificationLogo) {
        certificationLogo = newCertificationLogo;
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
     * @return the name and brief description of a certificate
     */
    public final String getCertificationName() {
        return certificationName;
    }
    
    /**
     * Get value of field gotCertificationYear.
     * 
     * @return the year where certificate was gained
     */
    public final Calendar getYearReceived() {
        return yearReceived;
    }
    
    /**
     * Get value of field certificationLogo.
     * 
     * @return the byte array of the logo
     */
    public final byte[] getCertificationLogo() {
        return certificationLogo;
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
