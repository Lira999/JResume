package com.softserveinc.ita.jresume.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.jresume.common.dto.CertificationDTO;
import com.softserveinc.ita.jresume.common.entity.Certification;

/**
 * Mapper for map Certification DTO and entity.
 * 
 * @author Bohdan Khudoba
 *         
 */
@Component
public class CertificationMapper
        implements GenericMapper<Certification, CertificationDTO> {
        
    @Override
    public final CertificationDTO toDto(final Certification certification) {
        CertificationDTO certificationDto = new CertificationDTO();
        certificationDto.setId(certification.getId());
        certificationDto.setLogo(certification.getLogo());
        certificationDto.setName(certification.getName());
        certificationDto.setYearReceived(certification.getYearReceived());
        certificationDto.setUserInformationId(
                certification.getUserInformation().getId());
        return certificationDto;
    }
    
    @Override
    public final Certification
            toEntity(final CertificationDTO certificationDto) {
        Certification certification = new Certification();
        certification.setId(certificationDto.getId());
        certification.setLogo(certificationDto.getLogo());
        certification.setName(certificationDto.getName());
        certification.setYearReceived(certificationDto.getYearReceived());
        return certification;
    }
    
}
