package com.market.Ecommerceapp.application.middlewares;

import com.market.Ecommerceapp.application.security.JWTUtils;
import com.market.Ecommerceapp.domain.helpers.AuthHelpers;
import com.market.Ecommerceapp.domain.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilterRequests extends OncePerRequestFilter {

    private UserService userService;
    private JWTUtils jwtUtils;

    public JWTFilterRequests(UserService userService, JWTUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
            String token = authorizationHeader.substring(7);
            String username = AuthHelpers.extractUsername(token);
            boolean isNotCurrentlyAuthenticate = SecurityContextHolder.getContext().getAuthentication() == null;

            if(username != null && isNotCurrentlyAuthenticate) {
                UserDetails userDetails = userService.loadUserByUsername(username);

                if(jwtUtils.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
