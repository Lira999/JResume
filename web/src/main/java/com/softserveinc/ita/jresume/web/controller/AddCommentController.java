package com.softserveinc.ita.jresume.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jresume.business.service.CommentService;
import com.softserveinc.ita.jresume.common.dto.MarkDTO;

/**
 * Controller for add comment and mark.
 * 
 * @author Bohdan Khudoba
 *         
 */
@Controller
@RequestMapping(value = "/addcomment")
public class AddCommentController {
    
    /** Comment Service to operate with comment objects. */
    @Autowired
    private CommentService commentService;
    
    /**
     * Controller for add comment and mark to template.
     * 
     * @param markDto
     *            Data transfer object for mark that be added.
     */
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public final void sendCommentAndMark(@RequestBody final MarkDTO markDto) {
        commentService.create(markDto);
    }
    
}
