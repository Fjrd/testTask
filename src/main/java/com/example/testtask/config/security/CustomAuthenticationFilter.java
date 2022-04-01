package com.example.testtask.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Value("${security.token}")
    private String verificationToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Token");
        try{
            if (Objects.isNull(token))
                throw new SecurityException("Missing header 'Token'");

            if (!Objects.equals(token, verificationToken))
                throw new SecurityException("Invalid token");

        } catch (SecurityException e){
            response.sendError(403);
        }
        filterChain.doFilter(request, response);
    }
}