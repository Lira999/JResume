package com.softserveinc.ita.jresume.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.dto.ProjectDTO;
import com.softserveinc.ita.jresume.common.entity.Project;
import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.common.mapper.ProjectMapper;
import com.softserveinc.ita.jresume.persistence.dao.impl.ProjectDAO;

/**
 * Class for working with project.
 * 
 * @author Bohdan Khudoba.
 *         
 */
@Service
public class ProjectService {
    
    /** projectMapper for map between DTO and entity. */
    @Autowired
    private ProjectMapper projectMapper;
    
    /** projectDAO for access to data storage. */
    @Autowired
    private ProjectDAO projectDao;
    
    /**
     * Gets list of ProjectDTO associated with user.
     * 
     * @param user
     *            user associated with this list ProjectDTO.
     * @return list of ProjectDTO associated with user.
     */
    public final List<ProjectDTO> getListOfDto(final User user) {
        List<Project> listOfEntity =
                user.getUserInformation().getProjects();
        List<ProjectDTO> result = new ArrayList<ProjectDTO>();
        for (Project project : listOfEntity) {
            result.add(projectMapper.toDto(project));
        }
        return result;
    }
    
    /**
     * Create a new project.
     * 
     * @param projectsDto
     *            Data transfer object for Project.
     * @param user
     *            user associated with this project.
     *            
     */
    public final void create(final List<ProjectDTO> projectsDto,
            final User user) {
        int countOfCurrentProjects =
                user.getUserInformation().getProjects().size();
        List<Project> listOfCurrentProject =
                user.getUserInformation().getProjects();
        for (int i = 0; i < countOfCurrentProjects; i++) {
            Project project = listOfCurrentProject.get(i);
            ProjectDTO projectDto = projectsDto.get(i);
            project.setCustomer(projectDto.getCustomer());
            project.setDescription(projectDto.getDescription());
            project.setInvolvementDuration(projectDto.getInvolvementDuration());
            project.setRole(projectDto.getRole());
            project.setTeamSize(projectDto.getTeamSize());
            project.setTools(projectDto.getTools());
            projectDao.update(project);
        }
        for (int i = countOfCurrentProjects; i < projectsDto.size(); i++) {
            Project project = projectMapper.toEntity(projectsDto.get(i));
            project.setUserInformation(user.getUserInformation());
            if (project.getCustomer() != null
                    && project.getDescription() != null
                    && project.getInvolvementDuration() != null
                    && project.getTeamSize() != null
                    && project.getTools() != null) {
                projectDao.create(project);
            }
        }
    }
    
}
