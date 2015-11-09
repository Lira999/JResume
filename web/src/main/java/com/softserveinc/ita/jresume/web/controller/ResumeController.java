package com.softserveinc.ita.jresume.web.controller;

import java.io.ByteArrayOutputStream;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public final String getCurrentTemplate(@PathVariable final Long id,
            final Principal principal) throws ResumeGeneratorException {
        System.err.println(id);
        User currentUser = userService.findByEmail(principal.getName());
        ByteArrayOutputStream output = (ByteArrayOutputStream) resumeGenerator
                .generate(currentUser.getUserInformation(), templateService
                        .findById(id));
        return output.toString();
    }
}
