package com.softserveinc.ita.jresume.common.dto;

import java.util.Date;

/**
 * Data Transfer Object for Base entity.
 * 
 * @author Bohdan Khudoba.
 * 
 */
public class BaseDTO {
    
    /** Value for creatBy. */
    private String createdBy;
    
    /** Value for creatBy. */
    private Date createDate;
    
    /** Value for creatBy. */
    private String updatedBy;
    
    /** Value for creatBy. */
    private Date updateDate;
    
    /**
     * Get value of createdBy.
     * 
     * @return value of createdBy
     */
    public final String getCreatedBy() {
        return createdBy;
    }
    
    /**
     * Set value of createdBy.
     * 
     * @param newCreatedBy
     *            value of createdBy
     */
    public final void setCreatedBy(final String newCreatedBy) {
        createdBy = newCreatedBy;
    }
    
    /**
     * Get value of createDate.
     * 
     * @return value of createDate
     */
    public final Date getCreateDate() {
        return createDate;
    }
    
    /**
     * Set value of createDate.
     * 
     * @param newCreateDate
     *            value of createDate
     */
    public final void setCreateDate(final Date newCreateDate) {
        createDate = newCreateDate;
    }
    
    /**
     * Get value of updatedBy.
     * 
     * @return value of updatedBy
     */
    public final String getUpdatedBy() {
        return updatedBy;
    }
    
    /**
     * Set value of updatedBy.
     * 
     * @param newUpdatedBy
     *            value of updatedBy
     */
    public final void setUpdatedBy(final String newUpdatedBy) {
        updatedBy = newUpdatedBy;
    }
    
    /**
     * Get value of updateDate.
     * 
     * @return value of updateDate
     */
    public final Date getUpdateDate() {
        return updateDate;
    }
    
    /**
     * Set value of updateDate.
     * 
     * @param newUpdateDate
     *            value of updateDate
     */
    public final void setUpdateDate(final Date newUpdateDate) {
        updateDate = newUpdateDate;
    }
    
}
