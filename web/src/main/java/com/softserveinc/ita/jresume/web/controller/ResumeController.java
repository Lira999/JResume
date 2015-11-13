package com.softserveinc.ita.jresume.web.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.generator.ResumeGenerator;
import com.softserveinc.ita.jresume.business.generator.ResumeGeneratorException;
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
    
    /** User service to operate with User objects. */
    @Autowired
    private UserService userService;
    
    /** Template service to operate with Template objects. */
    @Autowired
    private TemplateService templateService;
    
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
    public final String getResume(@PathVariable final Long id,
            final Principal principal) throws ResumeGeneratorException {
        User currentUser = userService.findByEmail(principal.getName());
        String result = new String(resumeGenerator.generate(currentUser
                .getUserInformation(), templateService.findById(id)));
        return result;
    }
    
    /**
     * Return generated resume in pdf format.
     * 
     * @param id
     *            id of target template
     * @param principal
     *            current spring security user, logged in system
     * @param response
     *            for file transfers
     * @throws ResumeGeneratorException
     *             in case of generation problems
     * @throws IOException
     *             in case of transferring exception
     */
    @RequestMapping(value = "/resumePdf", method = RequestMethod.GET)
    public final void getResumePdf(@PathVariable final Long id,
            final Principal principal, final HttpServletResponse response)
                    throws ResumeGeneratorException, IOException {
        User currentUser = userService.findByEmail(principal.getName());
        
        byte[] bytes = resumeGenerator.generatePdf(currentUser
                .getUserInformation(), templateService.findById(id));
                
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", String.format(
                "inline; filename=\"resume.pdf\""));
                
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        response.setContentLength((int) inputStream.available());
        FileCopyUtils.copy(new BufferedInputStream(inputStream), response
                .getOutputStream());
    }
    
    /**
     * Return generated resume in doc format.
     * 
     * @param id
     *            id of target template
     * @param principal
     *            current spring security user, logged in system
     * @param response
     *            for file transfers
     * @throws ResumeGeneratorException
     *             in case of generation problems
     * @throws IOException
     *             in case of transferring exception
     */
    @RequestMapping(value = "/resumeDoc", method = RequestMethod.GET)
    public final void getResumeDoc(@PathVariable final Long id,
            final Principal principal, final HttpServletResponse response)
                    throws ResumeGeneratorException, IOException {
        User currentUser = userService.findByEmail(principal.getName());
        byte[] bytes = resumeGenerator.generateDoc(currentUser
                .getUserInformation(), templateService.findById(id));
                
        response.setContentType("application/msword");
        
        response.setHeader("Content-Disposition", String.format(
                "inline; filename=\"resume.doc\""));
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        response.setContentLength((int) inputStream.available());
        
        FileCopyUtils.copy(new BufferedInputStream(inputStream), response
                .getOutputStream());
    }
}
