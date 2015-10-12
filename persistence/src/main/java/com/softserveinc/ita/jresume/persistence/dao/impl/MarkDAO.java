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
     * Create new mark by templateId.
     * 
     * @param mark
     *            Mark to be created.
     * @param templateId
     *            Find mark based on templateId.
     * @return created mark.
     */
    Mark create(final Mark mark, long templateId);
    
    /**
     * Find marks associated with this templateId.
     * 
     * @param templateId
     *            templateId of the template
     * @return the comments and marks associated with this template
     */
    List<Mark> findByTemplateId(Long templateId);
    
}
