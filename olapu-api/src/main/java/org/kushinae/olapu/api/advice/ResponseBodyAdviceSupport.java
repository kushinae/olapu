package org.kushinae.olapu.api.advice;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.kushinae.olapu.api.exceprion.UnAccessException;
import org.kushinae.olapu.api.exceprion.UniqueException;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.http.ErrorResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Log4j2
@RestControllerAdvice("org.kushinae.olapu.api.controller")
public class ResponseBodyAdviceSupport implements ResponseBodyAdvice<Object> {

    @Resource
    HttpServletRequest request;

    @ExceptionHandler(UniqueException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerUniqueException(UniqueException e) {
        preLogger(e);
        return ErrorResponse.conflict().message(getMessage(e.getMessage())).path(request.getMethod(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponse handlerIllegalArgumentException(IllegalArgumentException e) {
        preLogger(e);
        return ErrorResponse.badRequest().message(getMessage(e.getMessage())).path(request.getMethod(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnAccessException.class)
    public ErrorResponse handlerAccessTokenException(UnAccessException e) {
        preLogger(e);
        return ErrorResponse.forbidden().message(getMessage(e.getMessage())).path(request.getMethod(), request.getRequestURI());
    }

    private String getMessage(String code) {
        return ErrorMessage.matchDefaultMessageByCode(code);
    }

    private void preLogger(Exception e) {
        if (log.isErrorEnabled()) {
            log.error("[全局异常处理器] -- 获取异常 {} 消息 {}", e.getClass().getName(), e.getMessage(), e);
        }
    }


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ErrorResponse error) {
            error.path(request.getMethod().name(), request.getURI().getPath());
            return error;
        }
        return body;
    }
}
