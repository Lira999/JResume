package com.softserveinc.ita.jresume.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class represents mark table in database.
 */
@Entity
@Table(name = "mark")
public class Mark extends Base {
    
    /** value of this mark. */
    @Enumerated(EnumType.STRING)
    @Column(name = "mark")
    private MarkValue mark;
    
    /** comment to this mark. */
    @Column(name = "comment")
    private String comment;
    
    /**
     * template associated with this mark. Many to one relationship, references
     * to template table.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "templateId")
    private Template template;
    
    /** Author of this mark. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
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
