package com.softserveinc.ita.jresume.persistence.dao.impl;

import java.util.List;

import com.softserveinc.ita.jresume.common.entity.Template;
import com.softserveinc.ita.jresume.persistence.dao.GenericDAO;

/**
 * Interface describes specific methods, used for working with Template entity.
 * 
 * @author Golovii Sergii
 */
public interface TemplateDAO extends GenericDAO<Template, Long> {
    
    /**
     * Find template by name.
     * 
     * @param name
     *            target template name
     * @return founded template or {@code null} if template not found.
     */
            Template findByName(String name);
            
    /**
     * Load templates and sort them.
     * 
     * @param viewOnly
     *            parameter for choosing free/paid templates
     * @param sortBy
     *            parameter for choosing criteria for sorting templates
     *            
     * @return sorted list of templates
     */
            List<Template> findAndSort(String viewOnly, String sortBy);
            
}
