package com.softserveinc.ita.jresume.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.jresume.common.dto.MarkDTO;
import com.softserveinc.ita.jresume.common.entity.Mark;

/**
 * Mapper for map Mark DTO and entity.
 * 
 * @author Bohdan Khudoba.
 *         
 */
@Component
public class MarkMapper implements GenericMapper<Mark, MarkDTO> {
    
    @Override
    public final Mark toEntity(final MarkDTO markDto) {
        Mark mark = new Mark();
        mark.setComment(markDto.getComment());
        mark.setMark(markDto.getMark());
        mark.setCreateDate(markDto.getCreateDate());
        mark.setCreatedBy(markDto.getCreatedBy());
        return mark;
    }
    
    @Override
    public final MarkDTO toDto(final Mark mark) {
        if (mark.getUser() != null) {
            if (mark.getUser().getFirstName() == null) {
                System.err.println(mark.getUser().getFirstName()
                        + " ===== ===== ===== =====");
            } else {
                System.err.println("first name null");
                
            }
        } else {
            System.err.println("user null");
        }
        MarkDTO markDto = new MarkDTO();
        markDto.setComment(mark.getComment());
        markDto.setMark(mark.getMark());
        markDto.setCreateDate(mark.getCreateDate());
        markDto.setCreatedBy(mark.getCreatedBy());
        markDto.setTemplateId(mark.getTemplate().getId());
        return markDto;
    }
}
