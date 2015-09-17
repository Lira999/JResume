package com.softserveinc.ita.jresume.business.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.persistence.dao.impl.UserDAO;

/**
 * @author Andriy Zykhor
 *         
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    
    /**
     * User DAO for access to database.
     */
    @Autowired
    private UserDAO userDao;
    
    /**
     * Implemented method that load user by email.
     */
    @Override
    public final UserDetails loadUserByUsername(final String email)
            throws UsernameNotFoundException {
        com.softserveinc.ita.jresume.common.entity.User user =
                userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User does not exist.");
        }
        return new User(user.getEmail(),
                user.getPassword(),
                getGrantedAuthorities(user.getRole().toString()));
    }
    
    /**
     * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects.
     * 
     * @param roles
     *            {@link String} of roles
     * @return list of granted authorities
     */
    private List<GrantedAuthority> getGrantedAuthorities(
            final String... roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
    
}
