package com.softserveinc.ita.jresume.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    private double mark;
    
    /** author of this mark. */
    @Column(name = "addedBy")
    private String addedBy;
    
    /** comment to this mark. */
    private String comment;
    
    /**
     * template associated with this mark. Many to one relationship, references
     * to template table.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "templateId")
    private Template template;
    
    /** public constructor. */
    public Mark() {
        super();
    }
    
    /**
     * Gets mark value of this mark.
     * 
     * @return value of this mark
     */
    public final double getMark() {
        return mark;
    }
    
    /**
     * Changes mark value of this Mark.
     * 
     * @param newMark
     *            this marks new value
     */
    public final void setMark(final double newMark) {
        this.mark = newMark;
    }
    
    /**
     * Gets author (his email) of this mark.
     * 
     * @return author email of this mark
     */
    public final String getAddedBy() {
        return addedBy;
    }
    
    /**
     * Changes author's email for this mark.
     * 
     * @param newAddedBy
     *            new authors email for this mark
     */
    public final void setAddedBy(final String newAddedBy) {
        this.addedBy = newAddedBy;
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
        this.comment = newComment;
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
    
}
