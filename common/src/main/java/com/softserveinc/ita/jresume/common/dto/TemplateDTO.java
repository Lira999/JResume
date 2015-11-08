package com.softserveinc.ita.jresume.common.dto;

/**
 * Data Transfer Object for Template entity.
 * 
 * @author Bohdan Khudoba.
 * 
 */
public class TemplateDTO extends BaseDTO {
    
    /** Name of this template. */
    private String name;
    
    /** Description of this template. */
    private String description;
    
    /** Price of this template. */
    private Double price;
    
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
    public final Double getPrice() {
        return price;
    }
    
    /**
     * Changes price of this template.
     * 
     * @param newPrice
     *            this template's new price
     */
    public final void setPrice(final Double newPrice) {
        price = newPrice;
    }
    
}
