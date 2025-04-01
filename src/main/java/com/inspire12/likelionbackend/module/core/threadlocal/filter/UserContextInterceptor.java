package com.inspire12.likelionbackend.module.core.threadlocal.filter;

import ch.qos.logback.core.util.StringUtil;
import com.inspire12.likelionbackend.module.core.threadlocal.context.UserContextHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserContextInterceptor implements HandlerInterceptor {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String userName = request.getHeader("X-USER-NAME");
        if (StringUtil.isNullOrEmpty(userName)) {
            log.warn("X-USER-NAME header is empty");
            return false;
        }
        UserContextHolder.setUser(userName);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserContextHolder.clear();  // 메모리 누수 방지
    }
}