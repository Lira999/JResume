package com.softserveinc.ita.jresume.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class represents ordering table in database.
 */
@Entity
@Table(name = "ordering")
public class Ordering extends Base {
    
    /** User associated with this ordering.  Many to one relationship, 
     * references to ordering table */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;
    
    /** Template associated with this ordering.  Many to one relationship, 
     * references to ordering table */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "templateId")
    private Template template;
    
    /** Column for paid. */
    @Column(name = "paid")
    private Double paid;
    
    /** Column for isSuccessful. */
    @Column(name = "isSuccessful")
    private Boolean isSuccessful;
    
    /** Column for failureReason. */
    @Column(name = "failureReason")
    private String failureReason;
    
    /**
     * Public constructor for class Ordering.
     */
    public Ordering() {
        super();
    }
    
    /**
     * Get value of column orderBy.
     *
     * @return value of column orderBy
     */
    public final User getUser() {
        return user;
    }
    
    /**
     * Set value of column orderBy.
     * 
     * @param newUser
     *            value of column orderBy
     */
    public final void setUser(final User newUser) {
        user = newUser;
    }
    
    /**
     * Get value of column template.
     *
     * @return value of column template
     */
    public final Template getTemplate() {
        return template;
    }
    
    /**
     * Set value of column template.
     * 
     * @param newTemplate
     *            value of column template
     */
    public final void setTemplate(final Template newTemplate) {
        template = newTemplate;
    }
    
    /**
     * Get value of column paid.
     *
     * @return value of column paid
     */
    public final Double getPaid() {
        return paid;
    }
    
    /**
     * Set value of column paid.
     * 
     * @param newPaid
     *            value of column paid
     */
    public final void setPaid(final Double newPaid) {
        paid = newPaid;
    }
    
    /**
     * Get value of column isSuccessful.
     *
     * @return value of column isSuccessful
     */
    public final Boolean getIsSuccessful() {
        return isSuccessful;
    }
    
    /**
     * Set value of column isSuccessful.
     * 
     * @param newIsSuccessful
     *            value of column isSuccessful
     */
    public final void setIsSuccessful(final Boolean newIsSuccessful) {
        isSuccessful = newIsSuccessful;
    }
    
    /**
     * Get value of column failureReason.
     *
     * @return value of column failureReason
     */
    public final String getFailureReason() {
        return failureReason;
    }
    
    /**
     * Set value of column failureReason.
     * 
     * @param newFailureReason
     *            value of column failureReason
     */
    public final void setFailureReason(final String newFailureReason) {
        failureReason = newFailureReason;
    }
    
}