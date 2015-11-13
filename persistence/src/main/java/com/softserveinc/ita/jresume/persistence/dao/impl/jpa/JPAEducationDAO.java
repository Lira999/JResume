package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jresume.common.entity.Education;
import com.softserveinc.ita.jresume.persistence.dao.impl.EducationDAO;

/**
 * A concrete JPA implementation for Education DAO.
 * 
 * @author Andriy Luchko
 */
@Repository
public class JPAEducationDAO extends JPAGenericDAO<Education, Long>
        implements EducationDAO {
        
}
