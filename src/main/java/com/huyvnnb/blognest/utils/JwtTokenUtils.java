package com.huyvnnb.blognest.utils;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class JwtTokenUtils {
    @Value("${jwt.secretKey}")
    private String SECRET_KEY;
    @Value("${jwt.expiration}")
    private int expiration;
    public String generateToken(String email){
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .subject(email)
                .issuer("blognest.io")
                .issueTime(new Date())
                .expirationTime(new Date(System.currentTimeMillis() + expiration * 1000L))
                .jwtID(UUID.randomUUID().toString())
                .build();

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        SignedJWT signedJWT = new SignedJWT(header, claims);
        try {
            signedJWT.sign(new MACSigner(SECRET_KEY.getBytes()));
            return signedJWT.serialize();
        } catch (JOSEException e) {
            log.error("Cannot generate token: ", e);
            throw new RuntimeException(e);
        }
    }

    public boolean validateToken(String token) throws ParseException, JOSEException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        JWSVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());

        return signedJWT.verify(verifier) &&
                new Date().before(signedJWT.getJWTClaimsSet().getExpirationTime());
    }

    public String extractEmail(String token) throws ParseException {
        return SignedJWT.parse(token).getJWTClaimsSet().getSubject();
    }


}
