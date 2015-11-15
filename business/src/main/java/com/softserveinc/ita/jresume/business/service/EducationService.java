package com.softserveinc.ita.jresume.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.dto.EducationDTO;
import com.softserveinc.ita.jresume.common.entity.Education;
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
     * Gets list of EducationDTO associated with user.
     * 
     * @param user
     *            user associated with this list EducationDTO.
     * @return list of EducationDTO associated with user.
     */
    public final List<EducationDTO> getListOfDto(final User user) {
        List<Education> listOfEntity = user.getUserInformation().getEducation();
        List<EducationDTO> result = new ArrayList<EducationDTO>();
        for (Education education : listOfEntity) {
            result.add(educationMapper.toDto(education));
        }
        return result;
    }
    
    /**
     * Create a new education.
     * 
     * @param educationsDto
     *            Data transfer object for Education.
     * @param user
     *            user associated with this education.
     */
    public final void create(final List<EducationDTO> educationsDto,
            final User user) {
        int countOfCurrentEducations =
                user.getUserInformation().getEducation().size();
        List<Education> listOfCurrentEducation =
                user.getUserInformation().getEducation();
        for (int i = 0; i < countOfCurrentEducations; i++) {
            Education education = listOfCurrentEducation.get(i);
            EducationDTO educationDto = educationsDto.get(i);
            education.setDegreeReceived(educationDto.getDegreeReceived());
            education.setDepartment(educationDto.getDepartment());
            education.setGraduationYear(educationDto.getGraduationYear());
            education.setSchoolName(educationDto.getSchoolName());
            education.setUniversity(educationDto.getUniversity());
            educationDao.update(education);
        }
        for (int i = countOfCurrentEducations; i < educationsDto.size(); i++) {
            Education education =
                    educationMapper.toEntity(educationsDto.get(i));
            education.setUserInformation(user.getUserInformation());
            if (education.getDegreeReceived() != null
                    && education.getDepartment() != null
                    && education.getGraduationYear() != null
                    && education.getSchoolName() != null
                    && education.getUniversity() != null) {
                educationDao.create(education);
            }
        }
    }
}
