package com.leyou.common.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.leyou.common.entity.IJWTInfo;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class JwtUtils {

    // 创建token
    public static String creatToken(IJWTInfo user) throws IllegalArgumentException, UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String username = user.getName();
        String id = user.getId();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create().withHeader(map).withClaim("username", username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 360000)).sign((com.auth0.jwt.algorithms.Algorithm) algorithm);
        return token;
    }

    // 验证jwt
    public static DecodedJWT verifyJwt(String token) {
        DecodedJWT decodedJWT = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier jwtVerifier = JWT.require((com.auth0.jwt.algorithms.Algorithm) algorithm).build();
            decodedJWT = jwtVerifier.verify(token);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } /*catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/ catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return decodedJWT;
    }


    public static void main(String[] args) throws UnsupportedEncodingException{
        String username = "root";

        String id = "1111111111111";
       // System.out.println(creatToken("dad","111"));
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MDgxMzgxNDAsInVzZXJJZCI6MSwidXNlcm5hbWUiOiJyb290In0.OeRdHJZKmxFBqIN-A-uSNQK8JyKdzX-wcFR883oMqFA";
       System.out.println(verifyJwt("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MDgxMzgxNDAsInVzZXJJZCI6MSwidXNlcm5hbWUiOiJyb290In0.OeRdHJZKmxFBqIN-A-uSNQK8JyKdzX-wcFR883oMqFA"));
        System.out.println(verifyJwt(token).getClaims().get("username").asString());
    }



}