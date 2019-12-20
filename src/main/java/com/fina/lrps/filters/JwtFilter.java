package com.fina.lrps.filters;

import com.fina.lrps.utils.JwtUtil;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = {"/*"})
public class JwtFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String accessHeader = request.getHeader("accessHeader");
        if (JwtUtil.verify(accessHeader) || request.getServletPath().endsWith("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendError(404,"您需要登录！");
        }
    }

    @Override
    public void destroy() {

    }
}
