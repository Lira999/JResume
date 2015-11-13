package com.softserveinc.ita.jresume.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.CertificationService;
import com.softserveinc.ita.jresume.business.service.EducationService;
import com.softserveinc.ita.jresume.business.service.ProjectService;
import com.softserveinc.ita.jresume.business.service.

SoftServeUserInformationService;
import com.softserveinc.ita.jresume.business.service.UserService;
import com.softserveinc.ita.jresume.common.dto.CertificationDTO;
import com.softserveinc.ita.jresume.common.dto.EducationDTO;
import com.softserveinc.ita.jresume.common.dto.ProjectDTO;
import com.softserveinc.ita.jresume.common.dto.SoftServeUserInformationDTO;

/**
 * Controller for user information.
 * 
 * @author Bohdan Khudoba.
 *         
 */
@Controller
@RequestMapping(value = "userinformation")
public class AddSoftServeUserInformationController {
    
    /**
     * SoftServeUserInformationService to operate with SoftServeUserInformation
     * objects.
     */
    @Autowired
    private SoftServeUserInformationService softServeUserInformationService;
    
    /**
     * UserService to operate with User objects.
     */
    @Autowired
    private UserService userService;
    
    /**
     * EducationService to operate with Education objects.
     */
    @Autowired
    private EducationService educationService;
    
    /**
     * ProjectService to operate with Project objects.
     */
    @Autowired
    private ProjectService projectService;
    
    /**
     * CertificationService to operate with Service objects.
     */
    @Autowired
    private CertificationService certificationService;
    
    /**
     * Add SoftServeUserInformation page mapping.
     * 
     * @return softServeUserInformation page.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public final String editProfile() {
        return "userinformation";
    }
    
    /**
     * Controller for find current SoftServeUserInformation.
     * 
     * @param principal
     *            current spring security user, logged in system.
     * @return current SoftServeUserInformation.
     */
    @RequestMapping(value = "/result", produces = "application/json",
            method = RequestMethod.GET)
    @ResponseBody
    public final SoftServeUserInformationDTO
            getUser(final Principal principal) {
        return softServeUserInformationService
                .getDto(userService.findByEmail(principal.getName()));
    }
    
    /**
     * Controller for add education.
     * 
     * @param educationDto
     *            Data transfer object for Education that be added.
     * @param principal
     *            current spring security user, logged in system.
     */
    @RequestMapping(value = "education", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final void addEducation(@RequestBody final EducationDTO educationDto,
            final Principal principal) {
        educationService.create(educationDto,
                userService.findByEmail(principal.getName()));
    }
    
    /**
     * Controller for add project.
     * 
     * @param projectDto
     *            Data transfer object for Project that be added.
     * @param principal
     *            current spring security user, logged in system.
     */
    @RequestMapping(value = "project", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final void addProject(@RequestBody final ProjectDTO projectDto,
            final Principal principal) {
        projectService.create(projectDto,
                userService.findByEmail(principal.getName()));
    }
    
    /**
     * Controller for add certification.
     * 
     * @param certificationDto
     *            Data transfer object for Certification that be added.
     * @param principal
     *            current spring security user, logged in system.
     */
    @RequestMapping(value = "certification", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final void addCertification(
            @RequestBody final CertificationDTO certificationDto,
            final Principal principal) {
        certificationService.create(certificationDto,
                userService.findByEmail(principal.getName()));
    }
    
    /**
     * Controller for add SoftServeUserInformation.
     * 
     * @param softServeUserInformationDto
     *            Data transfer object for SoftServeUserInformation that be
     *            added.
     * @param principal
     *            current spring security user, logged in system.
     */
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final void getSoftServeUserInformation(
            @RequestBody final SoftServeUserInformationDTO
            
    softServeUserInformationDto,
            final Principal principal) {
        softServeUserInformationService.edit(softServeUserInformationDto,
                userService.findByEmail(principal.getName()));
    }
    
}
