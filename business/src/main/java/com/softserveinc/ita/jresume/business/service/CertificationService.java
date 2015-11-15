package com.softserveinc.ita.jresume.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.dto.CertificationDTO;
import com.softserveinc.ita.jresume.common.entity.Certification;
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
     * Gets list of CertificationDTO associated with user.
     * 
     * @param user
     *            user associated with this list CertificationDTO.
     * @return list of CertificationDTO associated with user.
     */
    public final List<CertificationDTO> getListOfDto(final User user) {
        List<Certification> listOfEntity =
                user.getUserInformation().getCertification();
        List<CertificationDTO> result = new ArrayList<CertificationDTO>();
        for (Certification certification : listOfEntity) {
            result.add(certificationMapper.toDto(certification));
        }
        return result;
    }
    
    /**
     * Create a new certification.
     * 
     * @param certificationsDto
     *            Data transfer object for Certification.
     * @param user
     *            user associated with this certification.
     */
    public final void create(final List<CertificationDTO> certificationsDto,
            final User user) {
        int countOfCurrentCertifications =
                user.getUserInformation().getCertification().size();
        List<Certification> listOfCurrentCertification =
                user.getUserInformation().getCertification();
        for (int i = 0; i < countOfCurrentCertifications; i++) {
            Certification certification = listOfCurrentCertification.get(i);
            CertificationDTO certificationDto = certificationsDto.get(i);
            certification.setName(certificationDto.getName());
            certification.setYearReceived(certificationDto.getYearReceived());
            certificationDao.update(certification);
        }
        for (int i = countOfCurrentCertifications; i < certificationsDto
                .size(); i++) {
            Certification certification =
                    certificationMapper.toEntity(certificationsDto.get(i));
            certification.setUserInformation(user.getUserInformation());
            if (certification.getName() != null
                    && certification.getYearReceived() != null) {
                certificationDao.create(certification);
            }
        }
    }
}
