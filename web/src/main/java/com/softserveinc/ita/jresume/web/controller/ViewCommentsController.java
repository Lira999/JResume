package com.softserveinc.ita.jresume.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.CommentService;
import com.softserveinc.ita.jresume.common.entity.Mark;

/**
 * Controller for view all comments and marks.
 * 
 * @author Bohdan Khudoba
 *         
 */
@Controller
@RequestMapping(value = "/viewcomments{templateId}")
public class ViewCommentsController {
    
    /** Variable for access to data storage. */
    @Autowired
    private CommentService commentService;
    
    /**
     * Comments implementation mapping.
     * 
     * @return model "viewcomments" view
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public final String viewComments() {
        return "viewcomments";
    }
    
    /**
     * Controller for load comments and marks for template.
     * 
     * @param templateId
     *            templateId associated with marks.
     *            
     * @return all comments for template.
     */
    @RequestMapping(value = "/result", produces = "application/json",
            method = RequestMethod.GET)
    @ResponseBody
    public final List<Mark> getComments(@PathVariable final long templateId) {
        return commentService.findByTemplateId(templateId);
    }
    
}
