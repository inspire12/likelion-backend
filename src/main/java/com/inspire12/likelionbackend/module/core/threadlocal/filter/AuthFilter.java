package com.inspire12.likelionbackend.module.core.threadlocal.filter;

import ch.qos.logback.core.util.StringUtil;
import com.inspire12.likelionbackend.module.core.threadlocal.context.UserContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthFilter extends OncePerRequestFilter {
    private Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO
        String userName = request.getHeader("X-USER-NAME");
        if (StringUtil.isNullOrEmpty(userName)) {
            log.warn("X-USER-NAME header is empty");
            return ;
        }
        UserContextHolder.setUser(userName);

        try {
            filterChain.doFilter(request, response);
        } finally {
            UserContextHolder.clear();
        }
    }
}