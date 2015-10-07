package com.softserveinc.ita.jresume.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.TemplateService;
import com.softserveinc.ita.jresume.common.entity.Template;

/**
 * Controller for view template page with current id.
 * 
 */
@Controller
@RequestMapping(value = "/viewtempl{id}")
public class ViewtemplController {
    
    /** Variable for access to data storage. */
    @Autowired
    private TemplateService templateService;
    
    /**
     * Templates page mapping.
     * 
     * @return model "viewtempl" view
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public final String uploadtmpl() {
        return "viewtempl";
    }
    
    /**
     * Controller for load info about concrete template to html.
     * 
     * @param id
     *            id of template to show.
     * @return Template data with current id.
     */
    @RequestMapping(value = "/res", produces = "application/json",
            method = RequestMethod.GET)
    @ResponseBody
    public final Template someinfo(@PathVariable final Long id) {
        return templateService.findById(id);
    }
}
