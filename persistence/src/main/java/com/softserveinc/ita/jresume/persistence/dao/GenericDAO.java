package com.softserveinc.ita.jresume.persistence.dao;

import java.util.List;

/**
 *
 * @param <Model>
 */
public interface GenericDAO<Model> {
    
    /**
     * 
     * @param entity
     *            Create and save new object in DB.
     * @return a unique element or null if none exists.
     */
    
    Model create(Model entity);
    
    /**
     * 
     * @param id
     *           Gets a unique element with an id, assumes column name is id.
     *            
     * @return  a unique element or null if none exists
     */
    
    Model findById(Long id);
    
    /**
     * 
     * @param entity
     *            choose Entity class to create a table.
     *            
     * @return a unique element or null if none exists.
     */
    
    Model update(Model entity);
    
    /**
     * 
     * @param id
     *            Remove the entity with the specified type and id from the data
     *            store.
     */
    
    void delete(Long id);
    
    /**
     * This loads all of the elements from the given table from the database.
     * @return a list of all the elements in a table specified by the model.
     */
    
    List<Model> findAll();
}
