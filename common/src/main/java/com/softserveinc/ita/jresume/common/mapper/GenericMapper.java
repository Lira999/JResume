package com.softserveinc.ita.jresume.common.mapper;

import org.springframework.stereotype.Component;

/**
 * This interface describes Generic Mapper.
 * 
 * @author Bohdan Khudoba.
 *         
 * @param <T>
 *            Type of Entity.
 * @param <V>
 *            Type of DTO.
 */
@Component
public interface GenericMapper<T, V> {
    
    /**
     * Map entity to DTO.
     * 
     * @param entity
     *            entity that be mapped.
     * @return dto.
     */
    V toDto(T entity);
    
    /**
     * Map DTO to entity.
     * 
     * @param dto
     *            dto that be mapped.
     * @return entity.
     */
    T toEntity(V dto);
    
}
