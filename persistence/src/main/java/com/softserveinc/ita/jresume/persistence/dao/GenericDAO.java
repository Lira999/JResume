package com.softserveinc.ita.jresume.persistence.dao;

import java.util.List;

/**
 * This interface describes Generic Dao.
 *
 * @param <T>
 *            = Type Of Entity accepts class.
 * @param <V>
 *            = Id Type
 *            
 */
public interface GenericDAO<T, V> {
    
    /**
     * Create a new entity.
     * 
     * @param entity
     *            Entity to be created.
     * @return created entity .
     */
    
    T create(T entity);
    
    /**
     * Find object based on the V Id.
     * 
     * @param id
     *            Find object based on the Id.
     * @return T entity.
     */
    
    T findById(V id);
    
    /**
     * Update information T entity.
     * @param entity
     *            object T entity to be updated.
     *            
     * @return updated entity.
     */
    
    T update(T entity);
    
    /**
     * Delete object by their Id.
     * 
     * @param id
     *            object to be deleted by id.
     *            
     */
    
    void deleteById(V id);
    
    /**
     * Delete T type.
     * 
     * @param entity
     *            the object to be deleted from DB.
     */
    
    void deleteEntity(T entity);
    
    /**
     * Get Entity from database.
     * 
     * @return a list of all the elements in Entity.
     */
    
    List<T> findAll();
}
