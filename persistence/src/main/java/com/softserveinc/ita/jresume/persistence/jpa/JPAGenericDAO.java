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
 *  @param <T> =  Name Of Entity
 *            The type of the domain object for which this instance is to be.
 *            used.
 * @param <V> = Id Type
 *          
 */
public abstract class JPAGenericDAO<T, V>
        implements GenericDAO<T, V> {
        
    /**
     * Entity manager is used to create / update / remove / find persistent
     * entity instances, and to query over entities.
     */
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Represents concrete Entity to work with.
     */
    private Class<T> entityType;
    
    /**
     * Single public constructor. Turn back name of entity to work with.
     */
    @SuppressWarnings("unchecked")
    public JPAGenericDAO() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityType = (Class<T>) genericSuperClass
                .getActualTypeArguments()[0];
    }
    
    @Override
    public final T create(final T entity) {
        entityManager.persist(entity);
        return entity;
    }
    
    @Override
    public final T update(final T entity) {
        return entityManager.merge(entity);
    }
    
    @Override
    public final T findById(final V id) {
        return entityManager.find(entityType, id);
    }
    
    @Override
    public final void deleteById(final V id) {
        T entity = findById(id);
        entityManager.remove(entity);
    }
    
    @Override
    public final void deleteEntity(final T entity) {
        entityManager.remove(entity);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public final List<T> findAll() {
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
