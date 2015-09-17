package com.softserveinc.ita.jresume.common.entity.entityListener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.softserveinc.ita.jresume.common.entity.Base;

/**
 * Entity Listeners for Base class.
 */
public class BaseEntityListener {
    
    /**
     * Set date before the object is persisted to the data store.
     * 
     * @param object
     *            of Base class
     */
    @PrePersist
    private void prePersist(final Base object) {
        object.setCreateDate(new Date());
    }
    
    /**
     * Set date before an object is updated.
     * 
     * @param object
     *            of Base class
     */
    @PreUpdate
    private void preUpdate(final Base object) {
        object.setUpdateDate(new Date());
    }
    
}
