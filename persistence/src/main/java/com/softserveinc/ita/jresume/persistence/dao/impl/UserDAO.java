package com.softserveinc.ita.jresume.persistence.dao.impl;

import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.persistence.dao.GenericDAO;

/**
 * @author Andriy Zykhor
 *         
 */
public interface UserDAO extends GenericDAO<User, Long> {
    
    /**
     * @param email
     *            email of the user
     * @return the user associated with this email
     */
    
    User findByEmail(String email);
    
}
