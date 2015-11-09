package com.softserveinc.ita.jresume.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.jresume.common.dto.UserDTO;
import com.softserveinc.ita.jresume.common.entity.User;

/**
 * Mapper for map User DTO and entity.
 * 
 * @author Bohdan Khudoba.
 *         
 */
@Component
public class UserMapper implements GenericMapper<User, UserDTO> {
    
    @Override
    public final UserDTO toDto(final User user) {
        UserDTO userDto = new UserDTO();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
    
    @Override
    public final User toEntity(final UserDTO userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return user;
    }
    
}
