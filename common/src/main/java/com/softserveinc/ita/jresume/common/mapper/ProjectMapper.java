package com.softserveinc.ita.jresume.common.mapper;

import com.softserveinc.ita.jresume.common.dto.ProjectDTO;
import com.softserveinc.ita.jresume.common.entity.Project;

/**
 * Mapper for map Project DTO and entity.
 * 
 * @author Bohdan Khudoba
 *         
 */
public class ProjectMapper implements GenericMapper<Project, ProjectDTO> {
    
    @Override
    public final ProjectDTO toDto(final Project project) {
        ProjectDTO projectDto = new ProjectDTO();
        projectDto.setCustomer(project.getCustomer());
        projectDto.setDescription(project.getDescription());
        projectDto.setId(project.getId());
        projectDto.setInvolvementDuration(project.getInvolvementDuration());
        projectDto.setRole(project.getProjectRole());
        projectDto.setTeamSize(project.getProjectTeamSize());
        projectDto.setTools(project.getTools());
        projectDto.setUserInformationId(project.getUserInformation().getId());
        return projectDto;
    }
    
    @Override
    public final Project toEntity(final ProjectDTO projectDto) {
        Project project = new Project();
        project.setCustomer(projectDto.getCustomer());
        project.setDescription(projectDto.getDescription());
        project.setId(projectDto.getId());
        project.setInvolvementDuration(projectDto.getInvolvementDuration());
        project.setRole(projectDto.getProjectRole());
        project.setTeamSize(projectDto.getProjectTeamSize());
        project.setTools(projectDto.getTools());
        return project;
    }
    
}
