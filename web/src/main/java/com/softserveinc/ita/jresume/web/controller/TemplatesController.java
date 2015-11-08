package com.softserveinc.ita.jresume.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.common.dto.TemplateDTO;
import com.softserveinc.ita.jresume.business.service.TemplateService;

/**
 * Controller for templates page.
 * 
 * @author Ira Lialikova
 */
@Controller
@RequestMapping(value = "/templates")
public class TemplatesController {
    
    /**
     * Variable for access to data storage.
     */
    @Autowired
    private TemplateService templateService;
    
    /**
     * Templates page mapping.
     * 
     * @return model "templates" view
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public final String templates() {
        return "templates";
    }
    
    /**
     * Controller for load all available templates in system.
     * 
     * @param viewOnly
     *            parameter for choosing free/paid templates
     * @param sortBy
     *            parameter for choosing criteria for sorting templates
     *            
     * @return listTemplates all available templates
     */
    @RequestMapping(value = "/list",
            produces = "application/json",
            method = RequestMethod.GET,
            params = { "viewOnly", "sortBy" })
    @ResponseBody
    public final List<TemplateDTO> getCurrentlyPages(
            @RequestParam("viewOnly") final String viewOnly,
            @RequestParam("sortBy") final String sortBy) {
        return templateService.findAndSort(viewOnly, sortBy);
    }
    
}
