package com.softserveinc.ita.jresume.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class describes Project entity which stores the information about
 * projects in which the developer has been involved.
 * 
 * This Project entity has a many to one relationship with the UserInformation
 * entity.
 * 
 * @author Andriy Luchko
 */
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name = "project")
public class Project extends Base {
    
    /**
     * Project description.
     */
    @XmlElement
    @Column(name = "description")
    private String description;
    
    /**
     * Describes project's customer.
     */
    @XmlElement
    @Column(name = "customer")
    private String customer;
    
    /**
     * Describes the role of which was involved.
     */
    @XmlElement
    @Column(name = "role")
    private String role;
    
    /**
     * Describes project's team size.
     */
    @XmlElement
    @Column(name = "teamSize")
    private Short teamSize;
    
    /**
     * Describes involvement duration in a project.
     */
    @XmlElement
    @Column(name = "involvementDuration")
    private Byte involvementDuration;
    
    /**
     * Describes tools and technologies which were used in a project.
     */
    @XmlElement
    @Column(name = "tools")
    private String tools;
    
    /**
     * Project associates with UserInformation. Many to one relationship,
     * references to usetInformation table
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userInformationId")
    private UserInformation userInformation;
    
    /**
     * Sets the project description.
     * 
     * @param newDescription
     *            description to set
     */
    public final void setDescription(final String newDescription) {
        description = newDescription;
    }
    
    /**
     * Sets the project's customer.
     * 
     * @param newCustomer
     *            name of a customer
     */
    public final void setCustomer(final String newCustomer) {
        customer = newCustomer;
    }
    
    /**
     * Sets the project role of a developer.
     * 
     * @param newRole
     *            description of a developer's position
     */
    public final void setRole(final String newRole) {
        role = newRole;
    }
    
    /**
     * Sets the team size of a project.
     * 
     * @param newTeamSize
     *            count of workers in a team
     */
    public final void setTeamSize(final Short newTeamSize) {
        teamSize = newTeamSize;
    }
    
    /**
     * Sets the project tools and technologies.
     * 
     * @param newTools
     *            tools and technologies were involved in a project
     */
    public final void setTools(final String newTools) {
        tools = newTools;
    }
    
    /**
     * Sets the involvement duration of a developer in a project.
     * 
     * @param newInvolvementDuration
     *            description of a time to be involvement
     */
    public final void setInvolvementDuration(
            final Byte newInvolvementDuration) {
        involvementDuration = newInvolvementDuration;
    }
    
    /**
     * Changes information about user associated with this project.
     * 
     * @param newUserInformation
     *            information about user.
     */
    public final void setUserInformation(
            final UserInformation newUserInformation) {
        userInformation = newUserInformation;
    }
    
    /**
     * Get value of field description.
     * 
     * @return value of column description
     */
    public final String getDescription() {
        return description;
    }
    
    /**
     * Get value of field customer.
     * 
     * @return customer of a project
     */
    public final String getCustomer() {
        return customer;
    }
    
    /**
     * Get value of field projectRole.
     * 
     * @return projectRole of a developer in a project
     */
    public final String getProjectRole() {
        return role;
    }
    
    /**
     * Get value of field projectTeamSize.
     * 
     * @return number of workers which were involved in a project
     */
    public final Short getProjectTeamSize() {
        return teamSize;
    }
    
    /**
     * Get value of field involvementDuration.
     * 
     * @return time have been spent in a project
     */
    public final Byte getInvolvementDuration() {
        return involvementDuration;
    }
    
    /**
     * Get value of field tools.
     * 
     * @return tools and technologies which were used in a project
     */
    public final String getTools() {
        return tools;
    }
    
    /**
     * Gets information about user associated with this project.
     * 
     * @return information about user associated with this project.
     */
    public final UserInformation getUserInformation() {
        return userInformation;
    }
    
}
