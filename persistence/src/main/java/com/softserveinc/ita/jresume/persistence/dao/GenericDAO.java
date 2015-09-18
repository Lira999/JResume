package com.softserveinc.ita.jresume.persistence.dao;

import java.util.List;

/**
 * This interface describes Generic Dao.
 *
 * @param <T>
 *            = Type Of Entity accepts the Entity Class.
 * @param <V>
 *            = Id Type
 *            
 */
public interface GenericDAO<T, V> {
    
    /**
     * Create a new entity.
     * 
     * @param entity
     *            Type to be created.
     * @return entity Type.
     */
    
    T create(T entity);
    
    /**
     * Find object based on the V Id.
     * 
     * @param id
     *            Find object based on the Id.
     * @return entity 
     *              Type.
     */
    
    T findById(V id);
    
    /**
     * Update information T type.
     * 
     * @param entity
     *            object in the Type to be updated.
     *            
     * @return T type.
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
     * Get Type from database.
     * 
     * @return a list of all the elements in the Type.
     */
    
    List<T> findAll();
}
