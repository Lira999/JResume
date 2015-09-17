package com.softserveinc.ita.jresume.persistence.dao;

import java.util.List;

/**
 *
 * @param <T>
 *            = Name Of Entity accepts the name of Entity Class.
 * @param <V>
 *            = Id Type
 *            
 */
public interface GenericDAO<T, V> {
    
    /**
     * Create a new entity record in the database.
     * 
     * @param entity
     *            Name Of Entity to be created.
     * @return entity.
     */
    
    T create(T entity);
    
    /**
     * Find object based on the entity Id.
     * 
     * @param id
     *            Find T based on the entity Id.
     * @return entity
     */
    
    T findById(V id);
    
    /**
     * Update information of entity.
     * 
     * @param entity
     *            to be updated.
     *            
     * @return entity.
     */
    
    T update(T entity);
    
    /**
     * Delete object by their Id.
     * 
     * @param id
     *            id object to be deleted from DB.
     *            
     */
    
    void deleteById(V id);
    
    /**
     * Delete entity.
     * 
     * @param entity
     *            the object to be deleted from DB.
     */
            void deleteEntity(T entity);
            
    /**
     * Get entity from database.
     * 
     * @return a list of all the elements in entity.
     */
    
    List<T> findAll();
}
