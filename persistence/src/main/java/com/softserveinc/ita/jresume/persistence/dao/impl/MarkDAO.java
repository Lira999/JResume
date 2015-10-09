package com.softserveinc.ita.jresume.persistence.dao.impl;

import java.util.List;

import com.softserveinc.ita.jresume.common.entity.Mark;
import com.softserveinc.ita.jresume.persistence.dao.GenericDAO;

/**
 * Interface describes specific methods, used for working with Mark entity.
 * 
 * @author Golovii Sergii
 */
public interface MarkDAO extends GenericDAO<Mark, Long> {
    
    /**
     * Find template associated with this templateId.
     * 
     * @param templateId
     *            templateId of the template
     * @return the comments and marks associated with this template
     */
     List<Mark> findByTemplateId(Long templateId);
            
}
