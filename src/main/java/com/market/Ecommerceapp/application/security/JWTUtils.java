package com.market.Ecommerceapp.application.security;

import com.market.Ecommerceapp.domain.helpers.AuthHelpers;
import com.market.Ecommerceapp.utils.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(SecurityConstants.JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SecurityConstants.JWT_SECRET)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return AuthHelpers.isValidUsername(token, userDetails) && !AuthHelpers.isTokenExpired(token);
    }

}
