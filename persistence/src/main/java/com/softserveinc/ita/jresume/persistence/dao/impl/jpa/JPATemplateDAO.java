package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import java.util.List;

import javax.persistence.Query;

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
        
    @SuppressWarnings("unchecked")
    @Override
    public final Template findByName(final String name) {
        Query query =
                getEntityManager()
                        .createQuery("FROM Template WHERE name=:name");
        query.setParameter("name", name);
        query.setMaxResults(1);
        List<Template> result = query.getResultList();
        Template target;
        if (result.isEmpty()) {
            target = null;
        } else {
            target = result.get(0);
        }
        return target;
    }
    
}
