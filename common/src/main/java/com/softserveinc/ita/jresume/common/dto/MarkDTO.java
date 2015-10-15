package com.softserveinc.ita.jresume.common.dto;

import com.softserveinc.ita.jresume.common.entity.MarkValue;
import com.softserveinc.ita.jresume.common.entity.Template;
import com.softserveinc.ita.jresume.common.entity.User;

/**
 * Data Transfer Object for Mark entity.
 * 
 * @author Bohdan Khudoba
 * 
 */
public class MarkDTO {
    
    /** value of this mark. */
    private MarkValue mark;
    
    /** comment to this mark. */
    private String comment;
    
    /**
     * template associated with this mark. Many to one relationship, references
     * to template table.
     */
    private Template template;
    
    /** Author of this mark. */
    private User user;
    
    /**
     * Gets value of this mark.
     * 
     * @return value of this mark
     */
    public final MarkValue getMark() {
        return mark;
    }
    
    /**
     * Changes value of this mark.
     * 
     * @param newMark
     *            new value for this mark
     */
    public final void setMark(final MarkValue newMark) {
        mark = newMark;
    }
    
    /**
     * Gets comment for this mark.
     * 
     * @return comment for this mark
     */
    public final String getComment() {
        return comment;
    }
    
    /**
     * Changes comment for this mark.
     * 
     * @param newComment
     *            new comment for this mark
     */
    public final void setComment(final String newComment) {
        comment = newComment;
    }
    
    /**
     * Gets template associated with this mark.
     * 
     * @return template associated with this mark.
     */
    public final Template getTemplate() {
        return template;
    }
    
    /**
     * Changes template associated with this mark.
     * 
     * @param newTemplate
     *            new template for this mark.
     */
    public final void setTemplate(final Template newTemplate) {
        template = newTemplate;
    }
    
    /**
     * Gets user associated with this mark.
     * 
     * @return user associated with this mark.
     */
    public final User getUser() {
        return user;
    }
    
    /**
     * Changes user associated with this mark.
     * 
     * @param newUser
     *            new author of this mark.
     */
    public final void setUser(final User newUser) {
        user = newUser;
    }
    
}
