package com.softserveinc.ita.jresume.web.requestFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.softserveinc.ita.jresume.common.entity.entityListener.LoggedUser;

/**
 * Class RequestFilter implement javax.servlet.Filter interface. Method doFilter
 * set in LoggedUser email of user for current request.
 * 
 * WebFilter annotation define a filter in a web application with filter name
 *            RequestFilter.
 * 
 */
@WebFilter(filterName = "RequestFilter")
public class RequestFilter implements Filter {
    
    @Override
    public final void destroy() {
        LoggedUser.setLoggedUser(null);
    }
    
    @Override
    public final void doFilter(final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain) throws IOException, ServletException {
        String email = null;
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            if (!(SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal() instanceof String)) {
                User currentUser = (User) SecurityContextHolder.getContext()
                        .getAuthentication().getPrincipal();
                email = currentUser.getUsername();
            }
        }
        LoggedUser.setLoggedUser(email);
        chain.doFilter(request, response);
    }
    
    @Override
    public void init(final FilterConfig fConfig) throws ServletException {
    }
    
}
