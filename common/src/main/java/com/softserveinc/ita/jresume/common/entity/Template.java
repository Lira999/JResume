package com.softserveinc.ita.jresume.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class represents template table in database.
 */
@Entity
@Table(name = "template")
public class Template extends Base {
    
    /** The name of this template. */
    @Column(name = "name")
    private String name;
    
    /** Description of this template. */
    @Column(name = "description")
    private String description;
    
    /** Price of this template. */
    @Column(name = "price")
    private double price;
    
    /** public constructor. */
    public Template() {
        super();
    }
    
    /**
     * Gets the name of this template.
     * 
     * @return this template name.
     */
    public final String getName() {
        return name;
    }
    
    /**
     * Changes the name of this template.
     * 
     * @param newName
     *            this template's new name
     */
    public final void setName(final String newName) {
        name = newName;
    }
    
    /**
     * Gets description of this template.
     * 
     * @return this template description
     */
    public final String getDescription() {
        return description;
    }
    
    /**
     * Changes description of this template.
     * 
     * @param newDescription
     *            this template's new description
     */
    public final void setDescription(final String newDescription) {
        description = newDescription;
    }
    
    /**
     * Gets price of this template.
     * 
     * @return this template price
     */
    public final double getPrice() {
        return price;
    }
    
    /**
     * Changes price of this template.
     * 
     * @param newPrice
     *            this template's new price
     */
    public final void setPrice(final double newPrice) {
        price = newPrice;
    }
    
}
