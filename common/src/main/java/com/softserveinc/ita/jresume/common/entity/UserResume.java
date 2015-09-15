package com.softserveinc.ita.jresume.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Describe UserResume entity class.
 */
@Entity
@Table(name = "userResume")
public class UserResume extends Base {
    
    /** Column for name. */
    @Column(name = "name")
    private String name;
    
    /**
     * template associated with this userResume. Many to one relationship,
     * references to template table.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "templateId")
    private Template template;
    
    /**
     * user associated with this userResume. Many to one relationship,
     * references to user table.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;
    
    /**
     * Get value of column name.
     * 
     * @return value of column name.
     */
    public final String getName() {
        return name;
    }
    
    /**
     * Set value of column name.
     * 
     * @param newName
     *            set name.
     */
    public final void setName(final String newName) {
        name = newName;
    }
    
    /**
     * Gets user associated with this userResume.
     * 
     * @return user associated with this userResume.
     */
    public final User getUser() {
        return user;
    }
    
    /**
     * Changes user associated with this userResume.
     * 
     * @param newUser
     *            new user for this userResume.
     */
    public final void setUser(final User newUser) {
        user = newUser;
    }
    
    /**
     * Gets template associated with this userResume.
     * 
     * @return template associated with this userResume.
     */
    public final Template getTemplate() {
        return template;
    }
    
    /**
     * Changes template associated with this userResume.
     * 
     * @param newTemplate
     *            new template for this userResume.
     */
    public final void setTemplate(final Template newTemplate) {
        template = newTemplate;
    }
    
}
