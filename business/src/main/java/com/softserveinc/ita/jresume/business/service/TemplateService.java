package com.softserveinc.ita.jresume.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.dto.TemplateDTO;
import com.softserveinc.ita.jresume.common.entity.Template;
import com.softserveinc.ita.jresume.common.mapper.TemplateMapper;

import java.util.ArrayList;
import java.util.List;
import com.softserveinc.ita.jresume.persistence.dao.impl.TemplateDAO;

/**
 * Class for working with Template.
 * 
 */
@Service
public class TemplateService {
    
    /** TemplateDAO for access to data storage. */
    @Autowired
    private TemplateDAO templateDao;
    
    /** TemplateMapper for map between DTO and entity. */
    @Autowired
    private TemplateMapper templateMapper;
    
    /**
     * Create a new template.
     * 
     * @param template
     *            to be created.
     * @return created template.
     */
    public final Template create(final Template template) {
        return templateDao.create(template);
    }
    
    /**
     * Update information template.
     * 
     * @param template
     *            object template to be updated.
     *            
     * @return updated template.
     */
    public final Template update(final Template template) {
        return templateDao.update(template);
    }
    
    /**
     * Delete template from data storage.
     * 
     * @param template
     *            the template to be deleted.
     */
    public final void delete(final Template template) {
        templateDao.delete(template);
    }
    
    /**
     * Find all templates.
     * 
     * @return a list of all templates.
     */
    public final List<Template> findAll() {
        return templateDao.findAll();
    }
    
    /**
     * Find the template by id.
     * 
     * @param id
     *            looking for id to loading object template
     *            
     * @return the template.
     */
    
    public final TemplateDTO findById(final long id) {
        return templateMapper.toDto(templateDao.findById(id));
    }
    
    /**
     * Find template by name.
     * 
     * @param name
     *            target template name
     * @return founded template or {@code null} if template not found.
     */
    public final Template findByName(final String name) {
        return templateDao.findByName(name);
    }
    
    /**
     * Method witch load and sort templates.
     * 
     * @param viewOnly
     *            parameter for selecting templates in accordance price
     *            
     * @param sortBy
     *            sort template by this parameter
     *            
     * @return list of all available templates
     */
    public final List<TemplateDTO> findAndSort(final String viewOnly,
            final String sortBy) {
        List<Template> listOfTemplate =
                templateDao.findAndSort(viewOnly, sortBy);
        List<TemplateDTO> listOfTemplateDto = new ArrayList<TemplateDTO>();
        for (Template template : listOfTemplate) {
            listOfTemplateDto.add(templateMapper.toDto(template));
        }
        return listOfTemplateDto;
    }

}
