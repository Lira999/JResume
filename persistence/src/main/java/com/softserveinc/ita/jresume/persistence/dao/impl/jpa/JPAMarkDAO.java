package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jresume.common.entity.Mark;
import com.softserveinc.ita.jresume.persistence.dao.impl.MarkDAO;

/**
 * JPA implementation for MarkDAO.
 * 
 * @author Golovii Sergii
 */
@Repository
public class JPAMarkDAO extends JPAGenericDAO<Mark, Long> implements MarkDAO {
    
    @Override
    @SuppressWarnings("unchecked")
    public final List<Mark> findByTemplateId(final Long templateId) {
        Query query =
                getEntityManager()
                        .createQuery("FROM Mark WHERE templateId=:templateId");
        query.setParameter("templateId", templateId);
        return query.getResultList();
    }
    
}
