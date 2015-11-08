package com.softserveinc.ita.jresume.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.jresume.common.dto.TemplateDTO;
import com.softserveinc.ita.jresume.common.entity.Template;

/**
 * Mapper for map Template DTO and entity.
 * 
 * @author Bohdan Khudoba.
 *
 */
@Component
public class TemplateMapper implements GenericMapper<Template, TemplateDTO> {
    
    @Override
    public final TemplateDTO toDto(final Template template) {
        TemplateDTO templateDto = new TemplateDTO();
        templateDto.setDescription(template.getDescription());
        templateDto.setName(template.getName());
        templateDto.setPrice(template.getPrice());
        templateDto.setId(template.getId());
        return templateDto;
    }
    
    @Override
    public final Template toEntity(final TemplateDTO templateDto) {
        Template template = new Template();
        template.setName(templateDto.getName());
        template.setDescription(templateDto.getDescription());
        template.setPrice(templateDto.getPrice());
        template.setId(templateDto.getId());
        return template;
    }
}
