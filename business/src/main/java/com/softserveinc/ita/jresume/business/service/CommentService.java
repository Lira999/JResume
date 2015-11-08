package com.softserveinc.ita.jresume.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.dto.MarkDTO;
import com.softserveinc.ita.jresume.common.entity.Mark;
import com.softserveinc.ita.jresume.common.mapper.MarkMapper;
import com.softserveinc.ita.jresume.persistence.dao.impl.MarkDAO;
import com.softserveinc.ita.jresume.persistence.dao.impl.TemplateDAO;
import com.softserveinc.ita.jresume.persistence.dao.impl.UserDAO;

/**
 * Class for working with Comment.
 * 
 * @author Bohdan Khudoba
 */
@Service
public class CommentService {
    
    /** MarkDAO for access to data storage. */
    @Autowired
    private MarkDAO markDao;
    
    /** UserDAO for access to data storage. */
    @Autowired
    private UserDAO userDao;
    
    /** TemplateDAO for access to data storage. */
    @Autowired
    private TemplateDAO templateDao;
    
    /** MarkMapper for map between DTO and entity. */
    @Autowired
    private MarkMapper markMapper;
    
    /**
     * Create a new mark.
     * 
     * @param markDto
     *            Data transfer object for Mark.
     * @param templateId
     *            associated with template.
     * @param userId
     *            associated with user.
     */
    public final void create(final MarkDTO markDto, final long templateId,
            final long userId) {
        Mark mark = markMapper.toEntity(markDto);
        mark.setUser(userDao.findById(userId));
        mark.setTemplate(templateDao.findById(templateId));
        mark.setCreatedBy(userDao.findById(userId).getFirstName() + " "
                + userDao.findById(userId).getLastName());
        markDao.create(mark);
    }
    
    /**
     * @param templateId
     *            templateId of the template.
     * @return all comments and marks associated with template.
     */
    public final List<MarkDTO> findByTemplateId(final long templateId) {
        List<MarkDTO> result = new ArrayList<MarkDTO>();
        List<Mark> listOfMarks = markDao.findByTemplateId(templateId);
        for (Mark mark : listOfMarks) {
            MarkDTO markDto = markMapper.toDto(mark);
            result.add(markDto);
        }
        return result;
    }
    
}
