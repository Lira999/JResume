package com.softserveinc.ita.jresume.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.TemplateService;
import com.softserveinc.ita.jresume.common.dto.TemplateDTO;

/**
 * Controller for view template page with current id.
 */
@Controller
@RequestMapping(value = "/viewtemplate/{id}")
public class ViewTemplateController {
    
    /** Template service to operate with Template objects. */
    @Autowired
    private TemplateService templateService;
    
    /**
     * Viewtemplate page mapping.
     * 
     * @return "viewtempl" view
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public final String viewTemplate() {
        return "viewtemplate";
    }
    
    /**
     * Search template by id and send it to page.
     * 
     * @param id
     *            id of target template
     * @return founded template object
     */
    @RequestMapping(value = "/res", produces = "application/json",
            method = RequestMethod.GET)
    @ResponseBody
    public final TemplateDTO getCurrentTemplate(@PathVariable final Long id) {
        return templateService.findById(id);
    }
}
