package com.market.Ecommerceapp.domain.helpers;

import com.market.Ecommerceapp.utils.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class AuthHelpers {
    public static Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token).getBody();
    }

    public static String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public static boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    public static boolean isValidUsername(String token, UserDetails userDetails) {
        String username = AuthHelpers.extractUsername(token);
        return userDetails.getUsername().equals(username);
    }
}
