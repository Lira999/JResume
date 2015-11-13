package com.softserveinc.ita.jresume.business.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.dto.SoftServeUserInformationDTO;
import com.softserveinc.ita.jresume.common.entity.SoftServeUserInformation;
import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.common.mapper.

SoftServeUserInformationMapper;
import com.softserveinc.ita.jresume.persistence.dao.impl.UserInformationDAO;

/**
 * Class for working with SoftServeUserInformation.
 * 
 * @author Bohdan Khudoba
 *         
 */
@Service
public class SoftServeUserInformationService {
    
    /** UserInformationDAO for access to data storage. */
    @Autowired
    private UserInformationDAO userInformationDao;
    
    /** SoftServeUserInformationMapper for map between DTO and entity. */
    @Autowired
    private SoftServeUserInformationMapper softServeUserInformationMapper;
    
    /**
     * Get SoftServeUserInformationDTO associated with user.
     * 
     * @param user
     *            current user.
     * @return SoftServeUserInformationDTO associated with user.
     */
    public final SoftServeUserInformationDTO getDto(final User user) {
        return softServeUserInformationMapper
                .toDto(user.getUserInformation()
                        .getSoftServeUserInformation());
    }
    
    /**
     * Edit SoftServeUserInformation.
     * 
     * @param softServeUserInformationDto
     *            DTO for SoftServeUserInformation entity.
     * @param user
     *            User associated with SoftServeUserInformation.
     */
    public final void
            edit(final SoftServeUserInformationDTO softServeUserInformationDto,
                    final User user) {
        if (user.getUserInformation() == null) {
            SoftServeUserInformation softServeUserInformation =
                    new SoftServeUserInformation();
            softServeUserInformation =
                    softServeUserInformationMapper
                            .toEntity(softServeUserInformationDto);
            softServeUserInformation.setUser(user);
            userInformationDao.create(softServeUserInformation);
            
        } else {
            SoftServeUserInformation softServeUserInformation =
                    user.getUserInformation().getSoftServeUserInformation();
            softServeUserInformation
                    .setFirstName(user.getFirstName());
            softServeUserInformation
                    .setLastName(user.getLastName());
            softServeUserInformation
                    .setPosition(softServeUserInformationDto.getPosition());
            softServeUserInformation
                    .setSummary(softServeUserInformationDto.getSummary());
            softServeUserInformation
                    .setBirthDate(softServeUserInformationDto.getBirthDate());
            softServeUserInformation
                    .setFrameworks(softServeUserInformationDto.getFrameworks());
            softServeUserInformation
                    .setHardware(softServeUserInformationDto.getHardware());
            softServeUserInformation.setMethodologies(
                    softServeUserInformationDto.getMethodologies());
            softServeUserInformation.setOperatingSystems(
                    softServeUserInformationDto.getOperatingSystems());
            softServeUserInformation
                    .setProgrammingLanguages(softServeUserInformationDto
                            .getProgrammingLanguages());
            softServeUserInformation
                    .setRdbms(softServeUserInformationDto.getRdbms());
            softServeUserInformation.setTechnologies(
                    softServeUserInformationDto.getTechnologies());
            softServeUserInformation.setTestingTools(
                    softServeUserInformationDto.getTestingTools());
            softServeUserInformation
                    .setTools(softServeUserInformationDto.getTools());
            softServeUserInformation
                    .setWebServers(softServeUserInformationDto.getWebServers());
            userInformationDao.update(softServeUserInformation);
        }
    }
    
    /**
     * Delete softServeUserInformation from storage.
     * 
     * @param softServeUserInformation
     *            the softServeUserInformation to be deleted.
     */
    public final void
            delete(final SoftServeUserInformation softServeUserInformation) {
        userInformationDao.delete(softServeUserInformation);
    }
    
}
