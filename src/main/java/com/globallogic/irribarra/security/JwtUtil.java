package com.globallogic.irribarra.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


/**
 * Utility class to manage the JWT token
 * 
 * @author M. Irribarra
 * @version 1.0
 * @since May 24, 2023
 */
@Component
public class JwtUtil implements Serializable {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.validity}")
    private String validity;

    /**
     * Get all claims in the JWT token
     * 
     * @param token JWT token
     * @return Uncrypted claim values
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * Get the expiration date from a JWT token
     * 
     * @param token JWT token
     * @return Expiration claim value
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * Get email from a JWT token
     * 
     * @param token JWT token
     * @return Subject claim value
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * Extract one claim from the JWT token
     * 
     * @param <T>            Claim type
     * @param token          JWT token
     * @param claimsResolver Claim to get
     * @return The Claim value or {@code null}
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Check if token is expired
     * 
     * @param token JWT token
     * @return {@code true} if expiration claim value is less than current value
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * Create a new JWT token
     * 
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    /**
     * Creates a new JWT token using claims, subject, the current timestamp and the
     * default validity using HS512 algorithm.
     * 
     * @param claims  Claims map
     * @param subject Token subject
     * @return New JWT token
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        // parse validity
        long valTime = 0L;
        if (validity != null && validity.length() > 1) {
            String qty = validity.substring(0, validity.length() - 1);
            String unit = validity.substring(validity.length() - 1).toLowerCase();
            try {
                valTime = Long.parseLong(qty);
                // Just support hours, minutes or seconds
                switch (unit) {
                    case "h":
                        valTime = valTime * 60;
                    case "m":
                        valTime = valTime * 60;
                    case "s":
                        valTime = valTime * 1000;
                        break;
                }
            } catch (NumberFormatException nfe) {
                // Invalid validity quantity
                System.err.println("Invalid validity quantity [" + qty + "]");
                return null;
            }
        } else {
            System.err.println("Null or empty jwt.validity property");
            return null;
        }
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + valTime))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * Validate a token
     * 
     * @param token       JWT token
     * @param userDetails User details
     * @return {@code true} if the username is the same and token is not expired.
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}