package com.softserveinc.ita.jresume.business.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.entity.SoftServeUserInformation;
import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.common.entity.UserInformation;
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
    
    /**
     * Create a new softServeUserInformation.
     * 
     * @param softServeUserInformation
     *            to be created.
     * @param user
     *            user associated with softServeUserInformation.
     * @return created SoftServeUserInformation.
     */
    public final UserInformation create(
            final SoftServeUserInformation softServeUserInformation,
            final User user) {
        softServeUserInformation.setUser(user);
        return userInformationDao.create(softServeUserInformation);
    }
    
    /**
     * Update a new softServeUserInformation.
     * 
     * @param newSoftServeUserInformation
     *            newSoftServeUserInformation object with updated information.
     * @param user
     *            user associated with softServeUserInformation.
     * @return updated SoftServeUserInformation.
     */
    public final UserInformation
            update(final SoftServeUserInformation newSoftServeUserInformation,
                    final User user) {
        SoftServeUserInformation softServeUserInformation =
                user.getUserInformation().getSoftServeUserInformation();
        softServeUserInformation
                .setBirthDate(newSoftServeUserInformation.getBirthDate());
        softServeUserInformation
                .setFirstName(newSoftServeUserInformation.getFirstName());
        softServeUserInformation
                .setFrameworks(newSoftServeUserInformation.getFrameworks());
        softServeUserInformation
                .setHardware(newSoftServeUserInformation.getHardware());
        softServeUserInformation
                .setLastName(newSoftServeUserInformation.getLastName());
        softServeUserInformation.setMethodologies(
                newSoftServeUserInformation.getMethodologies());
        softServeUserInformation.setOperatingSystems(
                newSoftServeUserInformation.getOperatingSystems());
        softServeUserInformation
                .setPosition(newSoftServeUserInformation.getPosition());
        softServeUserInformation.setProgrammingLanguages(
                newSoftServeUserInformation.getProgrammingLanguages());
        softServeUserInformation
                .setRdbms(newSoftServeUserInformation.getRdbms());
        softServeUserInformation
                .setSummary(newSoftServeUserInformation.getSummary());
        softServeUserInformation
                .setTechnologies(newSoftServeUserInformation.getTechnologies());
        softServeUserInformation
                .setTestingTools(newSoftServeUserInformation.getTestingTools());
        softServeUserInformation
                .setTools(newSoftServeUserInformation.getTools());
        softServeUserInformation
                .setWebServers(newSoftServeUserInformation.getWebServers());
                
        return userInformationDao.update(softServeUserInformation);
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
