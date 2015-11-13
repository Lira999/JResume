package com.softserveinc.ita.jresume.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.jresume.common.dto.EducationDTO;
import com.softserveinc.ita.jresume.common.entity.Education;

/**
 * Mapper for map Education DTO and entity.
 * 
 * @author Bohdan Khudoba
 *         
 */
@Component
public class EducationMapper implements GenericMapper<Education, EducationDTO> {
    
    @Override
    public final EducationDTO toDto(final Education education) {
        EducationDTO educationDto = new EducationDTO();
        educationDto.setDegreeReceived(education.getDegreeReceived());
        educationDto.setDepartment(education.getDepartment());
        educationDto.setGraduationYear(education.getGraduationYear());
        educationDto.setId(education.getId());
        educationDto.setSchoolName(education.getSchoolName());
        educationDto.setUniversity(education.getUniversity());
        educationDto
                .setUserInformationId(education.getUserInformation().getId());
        return educationDto;
    }
    
    @Override
    public final Education toEntity(final EducationDTO educationDto) {
        Education education = new Education();
        education.setDegreeReceived(educationDto.getDegreeReceived());
        education.setDepartment(educationDto.getDepartment());
        education.setGraduationYear(educationDto.getGraduationYear());
        education.setId(educationDto.getId());
        education.setSchoolName(educationDto.getSchoolName());
        education.setUniversity(educationDto.getUniversity());
        return education;
    }
    
}
