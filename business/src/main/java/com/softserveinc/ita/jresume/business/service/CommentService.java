package com.softserveinc.ita.jresume.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.dto.MarkDTO;
import com.softserveinc.ita.jresume.common.entity.Mark;
import com.softserveinc.ita.jresume.persistence.dao.impl.MarkDAO;

/**
 * Class for working with Comment.
 * 
 * @author Bohdan Khudoba
 */
@Service
public class CommentService {
    
    /** MarkDAO for access to data storage. */
    @Autowired
    private MarkDAO markDao;
    
    /**
     * Create a new mark.
     * 
     * @param markDto
     *            Data transfer object for Mark.
     * @param templateId
     *            associated with template.
     * @param userId
     *            associated with user.
     */
    public final void create(final MarkDTO markDto, final long templateId,
            final long userId) {
        markDao.create(markDto, templateId, userId);
    }
    
    /**
     * Update information mark.
     *
     * @param mark
     *            object mark to be updated.
     *            
     * @return updated mark.
     */
    public final Mark update(final Mark mark) {
        return markDao.update(mark);
    }
    
    /**
     * Delete mark from data storage.
     *
     * @param mark
     *            the mark to be deleted.
     */
    public final void delete(final Mark mark) {
        markDao.delete(mark);
    }
    
    /**
     * @param templateId
     *            templateId of the template.
     * @return all comments and marks associated with template.
     */
    public final List<Mark> findByTemplateId(final long templateId) {
        return markDao.findByTemplateId(templateId);
    }
    
    /**
     * Find all comments and marks.
     *
     * @return a list of all comments and marks.
     */
    public final List<Mark> findAll() {
        return markDao.findAll();
    }
    
}
