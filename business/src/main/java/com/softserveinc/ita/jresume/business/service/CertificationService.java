package com.softserveinc.ita.jresume.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.dto.CertificationDTO;
import com.softserveinc.ita.jresume.common.entity.Certification;
import com.softserveinc.ita.jresume.common.entity.SoftServeUserInformation;
import com.softserveinc.ita.jresume.common.entity.User;
import com.softserveinc.ita.jresume.common.mapper.CertificationMapper;
import com.softserveinc.ita.jresume.persistence.dao.impl.CertificationDAO;

/**
 * Class for working with Certification.
 * 
 * @author Bohdan Khudoba.
 *         
 */
@Service
public class CertificationService {
    
    /** CertificationMapper for map between DTO and entity. */
    @Autowired
    private CertificationMapper certificationMapper;
    
    /** certificationDAO for access to data storage. */
    @Autowired
    private CertificationDAO certificationDao;
    
    /**
     * Create a new certification.
     * 
     * @param certificationDto
     *            Data transfer object for Certification.
     * @param user
     *            user associated with this certification.
     */
    public final void create(final CertificationDTO certificationDto,
            final User user) {
        Certification certification =
                certificationMapper.toEntity(certificationDto);
                
        if (user.getUserInformation() == null) {
            certification.setUserInformation(new SoftServeUserInformation());
        } else {
            certification.setUserInformation(user.getUserInformation());
        }
        certificationDao.create(certification);
    }
}
