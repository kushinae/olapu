package org.kushinae.olapu.api.advice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.kushinae.olapu.api.annotation.AccessWhitelist;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.enums.TokenType;
import org.kushinae.olapu.api.exceprion.AccessTokenException;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.util.AccessTokenUtils;
import org.kushinae.olapu.api.util.JWTToken;
import org.kushinae.olapu.api.util.StringUtils;
import org.kushinae.olapu.core.utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Log4j2
@RestControllerAdvice("org.kushinae.olapu.api.controller")
public class RequestBodyAdviceSupport implements RequestBodyAdvice {

    private static final String LOG_STYLE = "\n\t";
    private static final String TOKEN_KEY = "Authorization";
    private static final TokenType tokenType = TokenType.BEARER;

    @Autowired
    HttpServletRequest request;


    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        Method method = parameter.getMethod();
        AccessWhitelist accessWhitelist = Objects.requireNonNull(method).getDeclaredAnnotation(AccessWhitelist.class);
        Class<?> declaringClass = Objects.requireNonNull(method).getDeclaringClass();
        if (null == accessWhitelist) {
            accessWhitelist = declaringClass.getDeclaredAnnotation(AccessWhitelist.class);
        }
        if (body instanceof Authorization authorization && null == accessWhitelist) {
            String authType = request.getAuthType();

            String header = request.getHeader(TOKEN_KEY);
            if (StringUtils.nonText(header) || !header.startsWith(tokenType.getSerial())) {
                throw new AccessTokenException(ErrorMessage.AUTHENTICATION_FAILED.getCode());
            }
            Pattern authorizationPattern = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-:._~+/]+=*)$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = authorizationPattern.matcher(header);
            if (!matcher.matches()) {
                throw new AccessTokenException(ErrorMessage.AUTHENTICATION_FAILED.getCode());
            }
            String token = matcher.group("token");
            JWTToken jwtToken = AccessTokenUtils.decryptJWT(token);
            authorization.setToken(token);
            authorization.setUid(jwtToken.getUid());
        }
        if (log.isInfoEnabled()) {
            log.info("\n[Request Logger]" + LOG_STYLE +
                    "Request \t\tpath: {} {}" + LOG_STYLE +
                    "Request \ttimestamp: {}" + LOG_STYLE +
                    "Request \t\tbody: {}" + LOG_STYLE +
                    "Request query params: {}"
                    ,request.getMethod(), request.getRequestURI(),
                    new Date(),
                    JacksonUtils.toJsonString(body),
                    JacksonUtils.toJsonString(request.getParameterMap()));
        }
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}
