package com.softserveinc.ita.jresume.persistence.dao;

import java.util.List;

/**
 *
 * @param <T> =  Name Of Entity
 *      accepts the name of Entity Class.
 * @param <V> = Id Type
 *          
 */
public interface GenericDAO<T, V> {
    
    /**
     * 
     * @param entity
     *            Create and save new object in DB.
     * @return a unique element or null if none exists.
     */
    
    T create(T entity);
    
    /**
     *  
     * @param id
     *         Find T based on the entity Id.   
     * @return  a unique element
     */
    
    T findById(V id);
    
    /**
     * 
     * @param entity
     *            choose Entity class to create a table.
     *            
     * @return a unique element or null if none exists.
     */
    
    T update(T entity);
    
    /**
     * 
     * @param id
     *            Remove the entity with the specified type and id from the data
     *            store.
     */
    
    void deleteById(V id);
    /**
     * 
     * @param entity
     *            Remove the entity with the specified type and id from the data
     *            store.
     */
    void deleteEntity(T entity);
    
    /**
     * This loads all of the elements from the given table from the database.
     * @return a list of all the elements in a table specified by the model.
     */
    
    List<T> findAll();
}
