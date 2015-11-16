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
        return mark;
    }
    
    @Override
    public final MarkDTO toDto(final Mark mark) {
        MarkDTO markDto = new MarkDTO();
        markDto.setComment(mark.getComment());
        markDto.setMark(mark.getMark());
        markDto.setCreateDate(mark.getCreateDate());
        markDto.setCreatedBy(mark.getCreatedBy());
        markDto.setTemplateId(mark.getTemplate().getId());
        return markDto;
    }
}
