package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.persistence.dao.impl.UserDAO;

/**
 * Implementation of User DAO.
 * 
 * @author Andriy
 *         
 */
@Repository
public class JPAUserDAO extends JPAGenericDAO<User, Long>
        implements UserDAO {
        
    @Override
    @SuppressWarnings("unchecked")
    public final User findByEmail(final String email) {
        Query query =
                getEntityManager().createQuery("FROM User WHERE email=:email");
        query.setParameter("email", email);
        query.setMaxResults(1);
        List<User> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
    
}
