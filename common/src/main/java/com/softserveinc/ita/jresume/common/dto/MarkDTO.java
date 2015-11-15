package com.softserveinc.ita.jresume.common.dto;

import com.softserveinc.ita.jresume.common.entity.MarkValue;

/**
 * Data Transfer Object for Mark entity.
 * 
 * @author Bohdan Khudoba
 * 
 */
public class MarkDTO extends BaseDTO {
    
    /** TemplateId associated with mark. */
    private Long templateId;
    
    /** Value of this mark. */
    private MarkValue mark;
    
    /** Comment to this mark. */
    private String comment;
    
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
     * Gets templateId for this mark.
     * 
     * @return templateId for this mark.
     */
    public final Long getTemplateId() {
        return templateId;
    }

    /**
     * Changes templateId for this mark.
     * 
     * @param newTemplateId
     *            new templateId for this mark.
     */
    public final void setTemplateId(final Long newTemplateId) {
        templateId = newTemplateId;
    }
    
    
    
}
