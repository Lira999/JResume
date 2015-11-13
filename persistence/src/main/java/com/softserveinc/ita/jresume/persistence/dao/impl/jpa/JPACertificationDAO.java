package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jresume.common.entity.Certification;
import com.softserveinc.ita.jresume.persistence.dao.impl.CertificationDAO;

/**
 * A concrete JPA implementation for Certification DAO.
 * 
 * @author Andriy Luchko
 */
@Repository
public class JPACertificationDAO extends JPAGenericDAO<Certification, Long>
        implements CertificationDAO {
        
}
