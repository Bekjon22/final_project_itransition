package com.itransition.security;


import com.itransition.common.MessageService;
import com.itransition.exception.RestException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


import java.util.Date;


/**
 * @author Bekjon Bakhromov
 * @since 03.07.2022
 */
@Component
public class JwtProvider {
    @Value("${jwt.secret-key}")
    private String secretKey;

//    @Value("${jwt.expire.access_token}")
//    private long accessTokenExpire;
//


    private static final long expireTime = 1000 * 60 * 60 * 24;

    public String generateToken(String username) {
        Date date = new Date(System.currentTimeMillis() + expireTime);
        return Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String getUsername(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            throw RestException.restThrow(MessageService.getMessage("FORBIDDEN"), HttpStatus.FORBIDDEN);
        }
    }

//    public void validateToken(String token) {
//        Jwts
//                .parser()
//                .setSigningKey(secretKey)
//                .parseClaimsJws(token);
//    }

}
