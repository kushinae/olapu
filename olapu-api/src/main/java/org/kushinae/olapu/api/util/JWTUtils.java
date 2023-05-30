package org.kushinae.olapu.api.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JWTUtils {


    public static String create(String uid) {
        Algorithm algorithm = Algorithm.HMAC256(uid);
        Map<String, Object> headers = new HashMap<>();
        headers.put("nickname", "HAHAHA");
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "ggboy");
        return JWT.create().withHeader(headers).withPayload(payload).withIssuer("ggboy").sign(algorithm);
    }

}
