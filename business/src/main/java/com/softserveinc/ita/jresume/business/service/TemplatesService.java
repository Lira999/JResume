package com.softserveinc.ita.jresume.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.entity.Template;
import com.softserveinc.ita.jresume.persistence.dao.impl.TemplateDAO;

/**
 * Templates service witch load all available templates.
 * 
 * @author Ira Lialikova
 */
@Service("templatesService")
public class TemplatesService {
    
    /**
     * Template DAO for access to database.
     */
    @Autowired
    private TemplateDAO templateDAO;
    
    /**
     * Method witch load all templates.
     * 
     * @return list of all available templates
     */
    public final List<Template> findAll() {
        return templateDAO.findAll();
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
    public final List<Template> findAndSort(final String viewOnly,
            final String sortBy) {
        return templateDAO.findAndSort(viewOnly, sortBy);
    }
    
}
