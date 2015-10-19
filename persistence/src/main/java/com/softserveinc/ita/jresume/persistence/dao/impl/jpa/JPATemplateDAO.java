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
    
    @Override
    @SuppressWarnings("unchecked")
    public final List<Template> findAndSort(final String viewOnly,
            final String sortBy) {
        String str1 = " ";
        String str2 = " ";
        switch (viewOnly) {
        case "ALL":
            str1 = " ";
            break;
        case "FREE":
            str1 = " WHERE price IS null";
            break;
        case "PAID":
            str1 = " WHERE price > 0";
            break;
        default:
            str1 = " ";
        }
        switch (sortBy) {
        case "NEWEST":
            str2 = " ORDER BY createDate DESC";
            break;        
        case "PRICE":
            str2 = " ORDER BY price ";
            break;
        default:
            str2 = " ";
        }
        Query query =
                getEntityManager().createQuery("FROM Template" + str1 + str2);
        return query.getResultList();
    }
    
}
