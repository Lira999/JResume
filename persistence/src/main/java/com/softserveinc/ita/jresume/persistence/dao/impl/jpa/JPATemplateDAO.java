package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jresume.common.entity.Template;
import com.softserveinc.ita.jresume.persistence.dao.impl.TemplateDAO;

/**
 * JPA implementation for Template DAO.
 * 
 * @author Golovii Sergii
 *         
 */
@Repository
public class JPATemplateDAO extends JPAGenericDAO<Template, Long>
        implements TemplateDAO {
        
}
