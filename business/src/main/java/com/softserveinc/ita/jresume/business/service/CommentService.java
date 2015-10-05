package com.softserveinc.ita.jresume.business.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.entity.Mark;
import com.softserveinc.ita.jresume.persistence.dao.impl.MarkDAO;

/**
 * Class for working with User.
 * 
 * @author Bohdan Khudoba
 */
@Service
public class CommentService {
    /** UserDAO for access to data storage. */
    @Autowired
    private MarkDAO markDao;
    
    /**
     * Create a new user.
     * 
     * @param mark
     *            to be created.
     * @return created user.
     */
    public final Mark create(final Mark mark) {
        return markDao.create(mark);
    }
    
    /**
     * Update information user.
     * 
     * @param mark
     *            object user to be updated.
     *            
     * @return updated user.
     */
    public final Mark update(final Mark mark) {
        return markDao.update(mark);
    }
    
    /**
     * Delete user from data storage.
     * 
     * @param mark
     *            the user to be deleted.
     */
    public final void delete(final Mark mark) {
        markDao.delete(mark);
    }
    
    /**
     * @param templateId
     *            templateId of the template
     * @return the template associated with this templateId
     */
    public final List<Mark> findByTemplateId(final long templateId) {
        return markDao.findByTemplateId(templateId);
    }
    
    /**
     * Find all comments and marks.
     * 
     * @return a list of all comments and marks
     */
    public final List<Mark> findAll() {
        return markDao.findAll();
    }
    
}
