package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.persistence.dao.impl.UserInformationDAO;

/**
 * JPA implementation for UserInformation DAO.
 * 
 * @author Bohdan Khudoba
 *         
 */
public class JPAUserInformationDAO extends JPAGenericDAO<User, Long>
        implements UserInformationDAO {
        
}
