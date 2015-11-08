/**
 * Package for entity classes.
 */
package com.softserveinc.ita.jresume.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.softserveinc.ita.jresume.common.entity.entityListener

.BaseEntityListener;

/**
 * Describe Base entity class.
 */
@XmlAccessorType(XmlAccessType.NONE)
@EntityListeners(BaseEntityListener.class)
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
    private Date createDate;
    
    /** Column for updatedBy. */
    @Column(name = "updatedBy")
    private String updatedBy;
    
    /** Column for updateDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateDate")
    private Date updateDate;
    
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
    public final Date getCreateDate() {
        return createDate;
    }
    
    /**
     * Set value of column createDate.
     * 
     * @param newCreateDate
     *            value of column createDate
     */
    public final void setCreateDate(final Date newCreateDate) {
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
    public final Date getUpdateDate() {
        return updateDate;
    }
    
    /**
     * Set value of column updateDate.
     * 
     * @param newUpdateDate
     *            value of column updateDate
     */
    public final void setUpdateDate(final Date newUpdateDate) {
        updateDate = newUpdateDate;
    }
    
}
