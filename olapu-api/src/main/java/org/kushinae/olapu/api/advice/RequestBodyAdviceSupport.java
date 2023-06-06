package org.kushinae.olapu.api.advice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.kushinae.olapu.core.utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Log4j2
@RestControllerAdvice("org.kushinae.olapu.api.controller")
public class RequestBodyAdviceSupport implements RequestBodyAdvice {

    private static final String LOG_STYLE = "\n\t";

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
