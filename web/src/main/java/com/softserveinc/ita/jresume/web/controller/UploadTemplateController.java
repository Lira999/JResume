package com.softserveinc.ita.jresume.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.softserveinc.ita.jresume.business.service.TemplateService;
import com.softserveinc.ita.jresume.common.entity.Template;



/**
 * Controller for view upload template page.
 * 
 */
@Controller
public class UploadTemplateController {
    
    /** Variable for access to data storage. */
    @Autowired
    private TemplateService templateService;
    
    
    
    /**
     * uploadtemplate page mapping.
     * 
     * @return uploadtemplate view.
     */
    @RequestMapping(value = "uploadtemplate", method = RequestMethod.GET)
    public final String register() {
        return "uploadtemplate";
    }
    
    /**
     * Controller create the new template.
     * 
     * @param template
     *            the template to be created.
     *         
     * @return map.
     */
    @RequestMapping(value = "uploadtemplate", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final Map<String, String> processRegistration(
            @RequestBody final Template template) {
            
      
        Map<String, String> map = new HashMap<String, String>();
        templateService.create(template);
        return map;
    }
}
