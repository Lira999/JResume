package com.softserveinc.ita.jresume.persistence.jpa;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.softserveinc.ita.jresume.persistence.dao.GenericDAO;

/**
 * 
 *
 * @param <Model>
 */
public abstract class JPAGenericDAO<Model> implements
        GenericDAO<Model> {
    /**
     * Javadoc.
     */
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Javadoc.
     */
    private Class<Model> entityType;
    /**
     * Javadoc.
     */
    @SuppressWarnings("unchecked")
    public JPAGenericDAO() {
        this.entityType = (Class<Model>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    /**
     * Javadoc.
     */
    @Override
    public final void create(final Model entity) {
        entityManager.persist(entity);
    }
    /**
     * Javadoc.
     */
    @Override
    public final Model update(final Model entity) {
        return entityManager.merge(entity);
    }
    /**
     * Javadoc.
     */
    @Override
    public final Model findById(final Long id) {
        return entityManager.find(entityType, id);
    }
    /**
     * Javadoc.
     */
    @Override
    public final Model delete(final Long id) {
        Model entity = findById(id);
        entityManager.remove(entity);
        return entity;
    }
    
}
