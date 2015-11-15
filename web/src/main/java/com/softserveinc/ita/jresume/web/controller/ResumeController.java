package com.softserveinc.ita.jresume.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.converter.ConverterException;
import com.softserveinc.ita.jresume.business.executor.ResumeConversionExecutor;
import com.softserveinc.ita.jresume.business.generator.ResumeGenerator;
import com.softserveinc.ita.jresume.business.generator.ResumeGeneratorException;
import com.softserveinc.ita.jresume.business.service.ConversionResult;
import com.softserveinc.ita.jresume.business.service.TemplateService;
import com.softserveinc.ita.jresume.business.service.UserService;
import com.softserveinc.ita.jresume.common.entity.User;

/**
 * Controller for view generated resume of current user.
 * 
 * @author Andriy Zykhor
 */
@Controller
@RequestMapping(value = "/viewtemplate/{id}")
public class ResumeController {
    
    /** Object for generating resume. */
    @Autowired
    private ResumeGenerator resumeGenerator;
    
    /** Executor that executes conversion resume to different formats. */
    @Autowired
    private ResumeConversionExecutor conversionExecutor;
    
    /** User service to operate with User objects. */
    @Autowired
    private UserService userService;
    
    /** Template service to operate with Template objects. */
    @Autowired
    private TemplateService templateService;
    
    /** Logger instance. */
    private static final Logger LOGGER = Logger.getLogger(
            UploadTemplateController.class);
            
    /**
     * Resume page mapping.
     * 
     * @return resume view.
     */
    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public final String register() {
        return "resume";
    }
    
    /**
     * Return generated resume of current user.
     * 
     * @param id
     *            id of target template
     * @param principal
     *            current spring security user, logged in system
     * @return html code of resume
     * @throws ResumeGeneratorException
     *             in case of generation problems
     */
    @RequestMapping(value = "/resumeGenerate", method = RequestMethod.POST)
    @ResponseBody
    public final ResponseEntity<String> getGeneratedResume(
            @PathVariable final Long id, final Principal principal) {
        User currentUser = userService.findByEmail(principal.getName());
        ResponseEntity<String> responseEntity;
        if (currentUser.getUserInformation() == null) {
            responseEntity = new ResponseEntity<String>("Empty data",
                    HttpStatus.CONFLICT);
        } else {
            try {
                String result = new String(resumeGenerator.generate(currentUser
                        .getUserInformation(), templateService.findById(id)));
                responseEntity = new ResponseEntity<String>(result,
                        HttpStatus.OK);
            } catch (ResumeGeneratorException e) {
                responseEntity = new ResponseEntity<String>(
                        "Error during resume generation",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return responseEntity;
    }
    
    /**
     * Return generated resume in pdf format.
     * 
     * @param id
     *            id of target template
     * @param format
     *            file format of the resume
     * @param principal
     *            current spring security user, logged in system
     * @param response
     *            for file transfers
     */
    @RequestMapping(value = "/resume/{format}", method = RequestMethod.GET)
    public final void getGeneratedFile(@PathVariable final Long id,
            @PathVariable final String format, final Principal principal,
            final HttpServletResponse response) {
        User currentUser = userService.findByEmail(principal.getName());
        try {
            byte[] resume = resumeGenerator.generate(currentUser
                    .getUserInformation(), templateService.findById(id));
                    
            String fileName = currentUser.getFirstName() + currentUser
                    .getLastName() + "-" + new SimpleDateFormat("dd-MM-yyyy")
                            .format(new Date());
            ConversionResult conversionResult = conversionExecutor.execute(
                    format, resume, fileName);
                    
            response.setContentType(conversionResult.getContentType());
            response.setHeader("Content-Disposition", conversionResult
                    .getHeader());
            response.setContentLength(conversionResult.getContentLenght());
            
            response.getOutputStream().write(conversionResult.getContent());
            response.setStatus(HttpStatus.OK.value());
        } catch (ResumeGeneratorException | ConverterException
                | IOException e) {
            LOGGER.error("Exception during creating resume", e);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
