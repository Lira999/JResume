package com.softserveinc.ita.jresume.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.dto.EducationDTO;
import com.softserveinc.ita.jresume.common.entity.Education;
import com.softserveinc.ita.jresume.common.entity.SoftServeUserInformation;
import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.common.mapper.EducationMapper;
import com.softserveinc.ita.jresume.persistence.dao.impl.EducationDAO;

/**
 * Class for working with Education.
 * 
 * @author Bohdan Khudoba.
 *         
 */
@Service
public class EducationService {
    
    /** EducationMapper for map between DTO and entity. */
    @Autowired
    private EducationMapper educationMapper;
    
    /** EducationDAO for access to data storage. */
    @Autowired
    private EducationDAO educationDao;
    
    /**
     * Create a new education.
     * 
     * @param educationDto
     *            Data transfer object for Education.
     * @param user
     *            user associated with this education.
     */
    public final void create(final EducationDTO educationDto, final User user) {
        Education education = educationMapper.toEntity(educationDto);
        if (user.getUserInformation() == null) {
            education.setUserInformation(new SoftServeUserInformation());
        } else {
            education.setUserInformation(user.getUserInformation());
        }
        educationDao.create(education);
    }
    
}
