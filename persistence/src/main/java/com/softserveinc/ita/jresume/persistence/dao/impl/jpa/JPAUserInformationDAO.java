package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jresume.common.entity.UserInformation;
import com.softserveinc.ita.jresume.persistence.dao.impl.UserInformationDAO;

/**
 * JPA implementation for UserInformation DAO.
 * 
 * @author Bohdan Khudoba
 *         
 */
@Repository
public class JPAUserInformationDAO extends JPAGenericDAO<UserInformation, Long>
        implements UserInformationDAO {
        
}
