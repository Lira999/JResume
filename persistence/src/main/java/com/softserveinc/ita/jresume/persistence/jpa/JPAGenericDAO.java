package com.softserveinc.ita.jresume.persistence.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.softserveinc.ita.jresume.persistence.dao.GenericDAO;

/**
 * Implementation of Generic DAO.
 *
 * @param <Model> 
 *            The type of the domain object for which this instance is to be
 *            used.
 */
public abstract class JPAGenericDAO<Model> implements GenericDAO<Model> {
    
    /**
     * Entity manager is used to create / update / remove / find persistent
     * entity instances, and to query over entities.
     */
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Represents concrete Entity to work with.
     */
    private Class<Model> entityType;
    
    /**
     * Single public constructor. Turn back name of entity to work with.
     */
    @SuppressWarnings("unchecked")
    public JPAGenericDAO() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityType = (Class<Model>) genericSuperClass
                .getActualTypeArguments()[0];
    }
    
    @Override
    public final Model create(final Model entity) {
        entityManager.persist(entity);
        return entity;
    }
    
    @Override
    public final Model update(final Model entity) {
        return entityManager.merge(entity);
    }
    
    @Override
    public final Model findById(final Long id) {
        return entityManager.find(entityType, id);
    }
    
    @Override
    public final void delete(final Long id) {
        Model entity = findById(id);
        entityManager.remove(entity);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public final List<Model> findAll() {
        Query query = entityManager.createQuery(
                "SELECT entity FROM " + entityType.getName() + " entity");
        return query.getResultList();
    }
    
    /**
     * 
     * @param newEntityManager
     *            Set entityManager
     */
    
    public final void setEntityManager(final EntityManager newEntityManager) {
        this.entityManager = newEntityManager;
    }
    
    /**
     * 
     * @return entityManager
     */
    public final EntityManager getEntityManager() {
        return entityManager;
    }
}
