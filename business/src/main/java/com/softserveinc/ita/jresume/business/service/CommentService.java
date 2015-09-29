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
     * @param user
     *            to be created.
     * @return created user.
     */
    public final Mark create(final Mark mark) {
        return markDao.create(mark);
    }
    
    /**
     * Update information user.
     * 
     * @param user
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
     * @param user
     *            the user to be deleted.
     */
    public final void delete(final Mark mark) {
        markDao.delete(mark);
    }
    
    /**
     * Find all users.
     * 
     * @return a list of all users.
     */
    public final List<Mark> findAll() {
        return markDao.findAll();
    }
    
}
