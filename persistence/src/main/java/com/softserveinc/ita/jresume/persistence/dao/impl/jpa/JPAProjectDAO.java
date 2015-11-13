package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jresume.common.entity.Project;
import com.softserveinc.ita.jresume.persistence.dao.impl.ProjectDAO;

/**
 * A concrete JPA implementation for Project DAO.
 * 
 * @author Andriy Luchko
 */
@Repository
public class JPAProjectDAO extends JPAGenericDAO<Project, Long>
        implements ProjectDAO {
        
}