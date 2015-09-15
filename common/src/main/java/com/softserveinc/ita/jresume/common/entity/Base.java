/**
 * Package for entity classes.
 */
package com.softserveinc.ita.jresume.common.entity;

import java.util.Calendar;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Describe Base entity class.
 */
@MappedSuperclass
public class Base {
    /** Column for Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** Column for creatBy. */
    @Column(name = "createdBy")
    private String createdBy;
    
    /** Column for createDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createDate")
    private Calendar createDate;
    
    /** Column for updatedBy. */
    @Column(name = "updatedBy")
    private String updatedBy;
    
    /** Column for updateDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateDate")
    private Calendar updateDate;
    
    /**
     * Get value of column id.
     * 
     * @return value of column id
     */
    public final Long getId() {
        return id;
    }
    
    /**
     * Set value of column id.
     * 
     * @param newId
     *            value of column id
     */
    public final void setId(final Long newId) {
        id = newId;
    }
    
    /**
     * Get value of column createdBy.
     * 
     * @return value of column createdBy
     */
    public final String getCreatedBy() {
        return createdBy;
    }
    
    /**
     * Set value of column createdBy.
     * 
     * @param newCreatedBy
     *            value of column createdBy
     */
    public final void setCreatedBy(final String newCreatedBy) {
        createdBy = newCreatedBy;
    }
    
    /**
     * Get value of column createDate.
     * 
     * @return value of column createDate
     */
    public final Calendar getCreateDate() {
        return createDate;
    }
    
    /**
     * Set value of column createDate.
     * 
     * @param newCreateDate
     *            value of column createDate
     */
    public final void setCreateDate(final Calendar newCreateDate) {
        createDate = newCreateDate;
    }
    
    /**
     * Get value of column updatedBy.
     * 
     * @return value of column updatedBy
     */
    public final String getUpdatedBy() {
        return updatedBy;
    }
    
    /**
     * Set value of column updatedBy.
     * 
     * @param newUpdatedBy
     *            value of column updatedBy
     */
    public final void setUpdatedBy(final String newUpdatedBy) {
        updatedBy = newUpdatedBy;
    }
    
    /**
     * Get value of column updateDate.
     * 
     * @return value of column updateDate
     */
    public final Calendar getUpdateDate() {
        return updateDate;
    }
    
    /**
     * Set value of column updateDate.
     * 
     * @param newUpdateDate
     *            value of column updateDate
     */
    public final void setUpdateDate(final Calendar newUpdateDate) {
        updateDate = newUpdateDate;
    }
    
}
