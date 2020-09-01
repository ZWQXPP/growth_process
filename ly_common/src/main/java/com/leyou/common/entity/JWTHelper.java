package com.leyou.common.entity;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.util.Map;

/**
 * Created by ace on 2017/9/10.
 */
public class JWTHelper {
    public static final String JWT_TOKEN_HEADER = "Authorization";

    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();
    private static final String JWT_KEY_USER_ID = "userId";
    private static final String JWT_KEY_NAME = "name";

    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKeyPath
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo jwtInfo, String priKeyPath, int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(JWT_KEY_NAME, jwtInfo.getName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKeyPath))
                .compact();
        return compactJws;
    }

    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateMobileToken(IJWTInfo jwtInfo, byte priKey[], int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(JWT_KEY_NAME, jwtInfo.getBindId())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
                .compact();
        return compactJws;
    }

    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo jwtInfo, byte priKey[], int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(JWT_KEY_NAME, jwtInfo.getName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;
    }
    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
        return claimsJws;
    }
    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get(JWT_KEY_USER_ID)), StringHelper.getObjectValue(body.get(JWT_KEY_NAME)));
    }
    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKey);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get(JWT_KEY_USER_ID)), StringHelper.getObjectValue(body.get(JWT_KEY_NAME)));
    }


    public static void main(String[] args) {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ3YW5nY2hlbmciLCJ1c2VySWQiOiJkZjkxZmE4MDQxOTkxMWU5YmUyYTdjZDMwYWUwMDkxMCIsIm5hbWUiOiLmsarnj7UiLCJleHAiOjE1NTc0MjU1MjN9.FWK_WGHAbrBt4mQxNIGNaDIyQB2pUoNk4XDSHFDDCGh5njOoEWbTFk8WcL8FwKgN90NC14ahXN_4umL6eevzORoAPDAcqevgi6eRAAgsKTOGPXcH0Dky9w6bI-o_XyDmi_3OYkJUk9vflujbtA5rOXxavDi_wl_jvRfyaF6VB5I";
        try {
            Map<String, byte[]> map = new RsaKeyHelper().generateKey("nt1UAE52^%9^SWES3");
            System.out.println(map);
            JWTHelper.getInfoFromToken(token, map.get("pub"));
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
