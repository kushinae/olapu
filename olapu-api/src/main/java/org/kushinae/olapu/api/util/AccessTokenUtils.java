package org.kushinae.olapu.api.util;

import cn.hutool.core.date.DateField;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.kushinae.olapu.api.enums.TokenType;
import org.kushinae.olapu.api.exceprion.UnAccessException;
import org.kushinae.olapu.api.exceprion.UnAuthorizationException;
import org.kushinae.olapu.api.http.ErrorMessage;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class AccessTokenUtils {

    private static final String jwtTokenSub = "Olapu a json web token";

    private static final String issueAt = "olapu.api.service-v1";

    public static String createFromJWT(String uid, String secret, String username) {
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
        payload.put("username", username);

        return JWT.create().withHeader(headers).withPayload(payload).withIssuer(issueAt).sign(algorithm);
    }

    public static JWTToken decryptJWT(String token) {
        DecodedJWT decode = JWT.decode(token);
        List<String> audience = decode.getAudience();
        if (CollectionUtils.isEmpty(audience)) {
            throw new UnAccessException(ErrorMessage.AUTHENTICATION_FAILED.getCode());
        }

        String uid = audience.get(0);
        if (StringUtils.nonText(uid)) {
            throw new UnAccessException(ErrorMessage.AUTHENTICATION_FAILED.getCode());
        }

        Instant expiresAtAsInstant = decode.getExpiresAtAsInstant();

        long epochSecond = expiresAtAsInstant.getEpochSecond();
        return JWTToken.builder().uid(uid).token(token).expiresAt(new Date(epochSecond)).username(decode.getClaim("username").asString()).build();
    }

    public static JWTToken checkAccessPurview(String authType, String header, TokenType tokenType) {
        if (StringUtils.nonText(header) || !header.startsWith(tokenType.getSerial())) {
            throw new UnAuthorizationException(ErrorMessage.AUTHENTICATION_FAILED);
        }
        Pattern authorizationPattern = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-:._~+/]+=*)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = authorizationPattern.matcher(header);
        if (!matcher.matches()) {
            throw new UnAuthorizationException(ErrorMessage.AUTHENTICATION_FAILED);
        }
        String token = matcher.group("token");
        JWTToken jwtToken = AccessTokenUtils.decryptJWT(token);
        if (System.currentTimeMillis() > jwtToken.getExpiresAt().getTime()) {
            throw new UnAuthorizationException(ErrorMessage.AUTHENTICATION_TOKEN_EXPIRED);
        }
        return jwtToken;
    }

}
