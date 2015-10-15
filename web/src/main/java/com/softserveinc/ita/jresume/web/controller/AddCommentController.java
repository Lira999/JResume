package com.softserveinc.ita.jresume.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.CommentService;
import com.softserveinc.ita.jresume.business.service.UserService;
import com.softserveinc.ita.jresume.common.dto.MarkDTO;
import com.softserveinc.ita.jresume.common.entity.User;

/**
 * Controller for add comment and mark.
 * 
 * @author Bohdan Khudoba
 *         
 */
@Controller
@RequestMapping(value = "/addcomment{templateId}")
public class AddCommentController {
    
    /** Comment Service to operate with comment objects. */
    @Autowired
    private CommentService commentService;
    
    /** User service to operate with user objects. */
    @Autowired
    private UserService userService;
    
    /**
     * Controller for add comment and mark to template.
     * 
     * @param markDto
     *            Data transfer object for mark that be added.
     * @param templateId
     *            templateId associated with mark.
     * @param principal
     *            current spring security user, logged in system.
     */
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final void sendCommentAndMark(
            @RequestBody final MarkDTO markDto,
            @PathVariable final Long templateId, final Principal principal) {
        Long userId = null;
        if (principal != null) {
            User currentUser = userService.findByEmail(principal.getName());
            userId = currentUser.getId();
            commentService.create(markDto, templateId, userId);
        }
    }
    
}
