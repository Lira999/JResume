package com.softserveinc.ita.jresume.persistence.dao.impl;

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
    
}
