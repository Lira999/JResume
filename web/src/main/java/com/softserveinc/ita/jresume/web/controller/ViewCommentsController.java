package com.softserveinc.ita.jresume.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = "/viewcommentsandmarks")
public class ViewCommentsController {

    /** Variable for access to data storage. */
    @Autowired
    private CommentService commentService;
    
    /**
     * Comments implementation mapping.
     * @return model "viewcommentsandmarks" view
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public final String uploadtmpl() {
        return "viewcommentsandmarks";
    }
    
    /**
     * Controller for load comments and marks for template.
     * 
     * @return all comments.
     */ 
    @RequestMapping(value = "/res", produces = "application/json",
            method = RequestMethod.GET)
    @ResponseBody
    public final List<Mark> getCommentsAndMarks() {
        return commentService.findAll();
    }
}
