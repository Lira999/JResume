package com.softserveinc.ita.jresume.persistence.dao.impl;

import java.util.List;

import com.softserveinc.ita.jresume.common.dto.MarkDTO;
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
     * @param markDto
     *            Mark to be mapped from markDto.
     * @param templateId
     *            Mark associated with Template by templateId.
     * @param userId
     *            Mark associated with User by userId.
     */
     void create(final MarkDTO markDto, final Long templateId,
                    final Long userId);
                    
    /**
     * Find marks associated with this templateId.
     * 
     * @param templateId
     *            templateId of the template
     * @return the comments and marks associated with this template
     */
     List<Mark> findByTemplateId(Long templateId);
            
}
