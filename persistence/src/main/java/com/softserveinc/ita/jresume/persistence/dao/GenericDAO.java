package com.softserveinc.ita.jresume.persistence.dao;

/**
 *
 * @param <Model>
 */
public interface GenericDAO<Model> {
    /**
     * 
     * @param entity
     *            This describes my type parameter.
     */
    void create(Model entity);
    
    /**
     * 
     * @param id
     *            This describes my type parameter.
     * 
     * @return Model
     */
    Model findById(Long id);
    
    /**
     * 
     * @param entity
     *            choose Entity class to create a table.
     * 
     * @return Model
     */
    Model update(Model entity);
    
    /**
     * 
     * @param id
     *            This describes my type parameter.
     * 
     * @return Model
     */
    Model delete(Long id);
}
