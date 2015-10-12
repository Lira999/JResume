package com.softserveinc.ita.jresume.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.CommentService;
import com.softserveinc.ita.jresume.common.entity.Mark;

/**
 * Controller for add comment and mark.
 * 
 * @author Bohdan Khudoba
 *         
 */
@Controller
@RequestMapping(value = "/addcomment{templateId}")
public class AddCommentController {
    
    /** Variable for access to data storage. */
    @Autowired
    private CommentService commentService;
    
    /**
     * Controller for add comment and mark to template.
     * 
     * @param mark
     *            mark to be added
     * @param templateId
     *            templateId associated with mark.
     */
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final void sendCommentAndMark(
            @RequestBody final Mark mark, @PathVariable final long templateId) {
        commentService.create(mark, templateId);
    }
    
}
