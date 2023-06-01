package org.kushinae.olapu.api.util;

import cn.hutool.core.date.DateField;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.kushinae.olapu.api.exceprion.AccessTokenException;
import org.kushinae.olapu.api.http.ErrorMessage;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class AccessTokenUtils {

    private static final String jwtTokenSub = "Olapu a json web token";

    private static final String issueAt = "olapu.api.service-v1";

    public static String createFromJWT(String uid, String secret) {
        Date currentDate = new Date();
        Algorithm algorithm = Algorithm.HMAC256(secret);
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        Map<String, Object> payload = new HashMap<>();
        // 签发主题
        payload.put("sub", jwtTokenSub);
        // 受众人
        payload.put("aud", uid);
        // jwt过期时间
        Date offset = DateUtils.offset(currentDate, DateField.MINUTE, 15);
        payload.put("exp", offset.getTime());
        // jwt生效时间 表示在此之前验证这个jwt则为失效
        payload.put("nbf", currentDate.getTime());
        // jwt签发时间
        payload.put("iat", currentDate.getTime());
        // 本次jwt令牌编号
        payload.put("jti", UUID.randomUUID().toString());

        return JWT.create().withHeader(headers).withPayload(payload).withIssuer(issueAt).sign(algorithm);
    }

    public static JWTToken decryptJWT(String token) {
        DecodedJWT decode = JWT.decode(token);
        List<String> audience = decode.getAudience();
        if (CollectionUtils.isEmpty(audience)) {
            throw new AccessTokenException(ErrorMessage.AUTHENTICATION_FAILED.getCode());
        }

        String uid = audience.get(0);
        if (StringUtils.nonText(uid)) {
            throw new AccessTokenException(ErrorMessage.AUTHENTICATION_FAILED.getCode());
        }

        Instant expiresAtAsInstant = decode.getExpiresAtAsInstant();
        long epochSecond = expiresAtAsInstant.getEpochSecond();
        return JWTToken.builder().uid(uid).token(token).expiresAt(new Date(epochSecond)).build();
    }

}
