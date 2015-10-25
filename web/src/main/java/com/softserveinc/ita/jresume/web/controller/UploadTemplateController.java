package com.softserveinc.ita.jresume.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import com.softserveinc.ita.jresume.business.service.TemplateService;
import com.softserveinc.ita.jresume.common.entity.Template;

/**
 * Controller for uploadtemplate page.
 * 
 */
@Controller
public class UploadTemplateController {
    
    /**
     * Path to folder to save files.
     */
    @Value("${fileUpload.path}")
    private String uploadPath;
    
    /**
     * Template service to operate with template objects.
     */
    @Autowired
    private TemplateService templateService;
    
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
     * @param files
     *            files to be saved.
     * @return true if files saved successfully or false in case of errors
     *         during saving
     */
    @RequestMapping(value = "/uploadfiles", method = RequestMethod.POST)
    @ResponseBody
    public final boolean uploadMultipleFileHandler(
            @RequestParam("name") final String name,
            @RequestParam("file") final MultipartFile[] files) {
        boolean result = false;
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            LOGGER.info("Start writing file " + file.getName());
            try {
                String fileExtension =
                        FilenameUtils.getExtension(file.getOriginalFilename());
                String nameOfFile = (name + "." + fileExtension);
                String filepath = Paths.get(uploadPath, nameOfFile).toString();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(filepath)));
                stream.write(file.getBytes());
                stream.close();
                result = true;
            } catch (MaxUploadSizeExceededException | IOException e) {
                LOGGER.error("Exceprion during writing file " + file.getName(),
                        e);
                result = false;
                break;
            }
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
    
    /**
     * Get current file upload path.
     * 
     * @return current file upload path.
     */
    public final String getUploadPath() {
        return uploadPath;
    }
    
    /**
     * Change current upload path.
     * 
     * @param newUploadPath
     *            path to upload files
     */
    public final void setUploadPath(final String newUploadPath) {
        uploadPath = newUploadPath;
    }
    
}
