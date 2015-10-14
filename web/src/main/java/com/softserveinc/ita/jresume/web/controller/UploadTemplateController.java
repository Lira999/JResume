package com.softserveinc.ita.jresume.web.controller;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
     * Controller to save files on server.
     * 
     * @param name
     *            name of files to be created.
     * @param files
     *            files to be saved.
     * @return message
     */
    @RequestMapping(value = "/uploadtemplatefile", method = RequestMethod.POST)
    @ResponseBody
    public final
            String uploadMultipleFileHandler(
                    @RequestParam("name") final String name,
                    @RequestParam("file") final MultipartFile[] files) {
        String message = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            try {
                String fileExtension =
                        FilenameUtils.getExtension(file.getOriginalFilename());
                String nameOfFile = (name + "." + fileExtension);
                String filedir = (System.getProperty("catalina.home")
                        + "/webapps/templatesDir");
                String filepath = Paths.get(filedir, nameOfFile).toString();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(filepath)));
                stream.write(file.getBytes());
                stream.close();
                message =
                        message + "You successfully uploaded file="
                                + nameOfFile
                                + "<br />";
            } catch (IOException e) {
                message =
                        message + "You failed to upload " + " => "
                                + e.getMessage();
            }
        }
        return message;
    }
    
}
	 

