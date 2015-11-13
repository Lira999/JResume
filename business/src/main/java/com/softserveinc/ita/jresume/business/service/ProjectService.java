package com.softserveinc.ita.jresume.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.dto.ProjectDTO;
import com.softserveinc.ita.jresume.common.entity.Project;
import com.softserveinc.ita.jresume.common.entity.SoftServeUserInformation;
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
     * Create a new project.
     * 
     * @param projectDto
     *            Data transfer object for Project.
     * @param user
     *            user associated with this project.
     *            
     */
    public final void create(final ProjectDTO projectDto, final User user) {
        Project project = projectMapper.toEntity(projectDto);
        if (user.getUserInformation() == null) {
            project.setUserInformation(new SoftServeUserInformation());
        } else {
            project.setUserInformation(user.getUserInformation());
        }
        projectDao.create(project);
    }
    
}
