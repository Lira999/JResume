package com.softserveinc.ita.jresume.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.softserveinc.ita.jresume.business.service.FileUploadService;
import com.softserveinc.ita.jresume.business.service.TemplateService;
import com.softserveinc.ita.jresume.common.entity.Template;

/**
 * Controller for uploadtemplate page.
 * 
 */
@Controller
public class UploadTemplateController {
    
    /**
     * Template service to operate with template objects.
     */
    @Autowired
    private TemplateService templateService;
    
    /**
     * File upload service to handle file upload.
     */
    @Autowired
    private FileUploadService fileUploadService;
    
    /**
     * Logger instance.
     */
    private static final Logger LOGGER =
            Logger.getLogger(UploadTemplateController.class);
            
    /**
     * uploadtemplate page mapping.
     * 
     * @return uploadtemplate view.
     */
    @RequestMapping(value = "uploadtemplate", method = RequestMethod.GET)
    public final String uploadTemplteView() {
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
    public final Map<String, String> createtemplateWithData(
            @RequestBody final Template template) {
        Map<String, String> map = new HashMap<String, String>();
        templateService.create(template);
        return map;
    }
    
    /**
     * Save files on server side.
     * 
     * @param name
     *            name of files to be created.
     * @param image
     *            image with template preview
     * @param schema
     *            xsl template schema
     * @return true if files saved successfully or false in case of errors
     *         during saving
     */
    @RequestMapping(value = "/uploadfiles", method = RequestMethod.POST)
    @ResponseBody
    public final boolean uploadMultipleFileHandler(
            @RequestParam("name") final String name,
            @RequestParam("image") final MultipartFile image,
            @RequestParam("schema") final MultipartFile schema) {
        boolean result = false;
        try {
            LOGGER.info(
                    "Start writing files " + image.getOriginalFilename() + " "
                            + schema.getOriginalFilename());
            result = fileUploadService.saveFile(image.getBytes(), name,
                    FilenameUtils.getExtension(image.getOriginalFilename()))
                    && fileUploadService.saveFile(schema.getBytes(), name,
                            FilenameUtils.getExtension(
                                    schema.getOriginalFilename()));
        } catch (MaxUploadSizeExceededException | IOException e) {
            LOGGER.error("Exception during writing files ", e);
            result = false;
        }
        return result;
    }
    
    /**
     * Check for template name availability.
     * 
     * @param name
     *            name of template to be found.
     * @return true if template name is available.
     */
    @RequestMapping(value = "templateExists", method = RequestMethod.POST)
    @ResponseBody
    public final Boolean checkName(final String name) {
        return templateService.findByName(name) == null;
    }
    
}
