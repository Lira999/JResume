package com.softserveinc.ita.jresume.persistence.dao.impl;

import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.persistence.dao.GenericDAO;

/**
 * Interface describes specific methods, used for working with User entity.
 * 
 * @author Andriy Zykhor
 *         
 */
public interface UserDAO extends GenericDAO<User, Long> {
    
    /**
     * Find user associated with this email.
     * 
     * @param email
     *            email of the user
     * @return the user associated with this email
     */
    User findByEmail(String email);
    
}
