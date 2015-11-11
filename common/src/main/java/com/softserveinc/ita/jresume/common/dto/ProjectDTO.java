package com.softserveinc.ita.jresume.common.dto;

/**
 * Data Transfer Object for Project entity.
 * 
 * @author Bohdan Khudoba.
 * 
 */
public class ProjectDTO extends BaseDTO {
    
    /**
     * Project Id.
     */
    private Long id;
    
    /**
     * Project description.
     */
    private String description;
    
    /**
     * Describes project's customer.
     */
    private String customer;
    
    /**
     * Describes the role of which was involved.
     */
    private String role;
    
    /**
     * Describes project's team size.
     */
    private Short teamSize;
    
    /**
     * Describes involvement duration in a project.
     */
    private Byte involvementDuration;
    
    /**
     * Describes tools and technologies which were used in a project.
     */
    private String tools;
    
    /**
     * Id associated with UserInformation.
     */
    private Long userInformationId;
    
    /**
     * Gets userInformationId.
     * 
     * @return userInformationId.
     */
    public final Long getUserInformationId() {
        return userInformationId;
    }
    
    /**
     * Changes userInformationId.
     * 
     * @param newUserInformationId
     *            new userInformationId.
     */
    public final void setUserInformationId(final Long newUserInformationId) {
        userInformationId = newUserInformationId;
    }
    
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
     * Get value of id.
     * 
     * @return id of this project.
     */
    public final Long getId() {
        return id;
    }
    
    /**
     * Change value of this id.
     * 
     * @param newId
     *            id of this project to be changed.
     */
    public final void setId(final Long newId) {
        id = newId;
    }
    
    /**
     * Get value value of role.
     * 
     * @return role.
     */
    public final String getRole() {
        return role;
    }
    
    /**
     * Get value value of team size.
     * 
     * @return team size.
     */
    public final Short getTeamSize() {
        return teamSize;
    }
    
}
