package com.market.Ecommerceapp.application.controller;

import com.market.Ecommerceapp.application.security.JWTUtils;
import com.market.Ecommerceapp.domain.dto.AuthRequest;
import com.market.Ecommerceapp.domain.dto.AuthResponse;
import com.market.Ecommerceapp.domain.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserService userService;
    private JWTUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, JWTUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping()
    public ResponseEntity<AuthResponse> createToken(@RequestBody  AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
            String token = jwtUtils.generateToken(userDetails);

            return new ResponseEntity<>(new AuthResponse(token), HttpStatus.OK);
        } catch(BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
