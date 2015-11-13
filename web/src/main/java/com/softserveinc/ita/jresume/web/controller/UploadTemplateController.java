package com.softserveinc.ita.jresume.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.softserveinc.ita.jresume.business.enums.FileExtensions;
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
     * Error message to display in case of errors during file transfer.
     */
    private final String errorMessage = new String(
            "Upload failed. We accept only files, less then 1 MB. "
                    + "Please, check your files and try again later.");
                    
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
     * @return responceEntity with information about upload status
     */
    @RequestMapping(value = "/uploadfiles", method = RequestMethod.POST)
    public final ResponseEntity<String> uploadMultipleFileHandler(
            @RequestParam("name") final String name,
            @RequestParam("image") final MultipartFile image,
            @RequestParam("schema") final MultipartFile schema) {
        ResponseEntity<String> responseEntity = null;
        try {
            LOGGER.info(
                    "Start writing files " + image.getOriginalFilename() + " "
                            + schema.getOriginalFilename());
            fileUploadService.saveFile(image.getBytes(), name,
                    FileExtensions.PNG);
            fileUploadService.saveFile(schema.getBytes(), name,
                    FileExtensions.XSL);
            responseEntity =
                    new ResponseEntity<String>("OK",
                            HttpStatus.OK);
        } catch (MaxUploadSizeExceededException | IOException e) {
            LOGGER.error("Exception during writing files ", e);
            responseEntity =
                    new ResponseEntity<String>(errorMessage,
                            HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
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
