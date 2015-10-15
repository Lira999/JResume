package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import java.util.List;

import javax.persistence.Query;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jresume.common.dto.MarkDTO;
import com.softserveinc.ita.jresume.common.entity.Mark;
import com.softserveinc.ita.jresume.common.entity.Template;
import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.persistence.dao.impl.MarkDAO;

/**
 * JPA implementation for MarkDAO.
 * 
 * @author Golovii Sergii
 */
@Repository
public class JPAMarkDAO extends JPAGenericDAO<Mark, Long> implements MarkDAO {
    /** Mapper for convert from DTO to entity. */
    private Mapper beanMapper = new DozerBeanMapper();
    
    @Override
    public final void create(final MarkDTO markDto, final Long templateId,
            final Long userId) {
        Query query =
                getEntityManager().createQuery("FROM Template WHERE id=:id");
        query.setParameter("id", templateId);
        Template template = (Template) query.getResultList().get(0);
        
        query = getEntityManager().createQuery("FROM User WHERE id=:id");
        query.setParameter("id", userId);
        User user = (User) query.getResultList().get(0);
        
        String createdBy = user.getFirstName() + " " + user.getLastName();
        
        Mark mark = beanMapper.map(markDto, Mark.class);
        mark.setCreatedBy(createdBy);
        mark.setUser(user);
        mark.setTemplate(template);
        getEntityManager().persist(mark);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public final List<Mark> findByTemplateId(final Long templateId) {
        Query query =
                getEntityManager()
                        .createQuery("FROM Mark WHERE templateId=:templateId");
        query.setParameter("templateId", templateId);
        List<MarkDTO> listMarkDto = query.getResultList();
        return beanMapper.map(listMarkDto, List.class);
    }
    
}
