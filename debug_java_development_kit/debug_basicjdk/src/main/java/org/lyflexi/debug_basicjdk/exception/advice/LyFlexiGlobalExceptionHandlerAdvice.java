package org.lyflexi.debug_basicjdk.exception.advice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.lyflexi.debug_basicjdk.exception.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/23 8:19
 */
@Slf4j
@RestControllerAdvice
public class LyFlexiGlobalExceptionHandlerAdvice extends DefaultGlobalExceptionHandlerAdvice{

    /**
     * 前端传参类型不匹配
     * @param e
     * @return
     */
    @ExceptionHandler(value = {InvalidFormatException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> invalidFormatException (Exception e) {
        log.error("InvalidFormatException:", e);
        return Result.fail(e.getCause().getMessage());
    }
    /**
     * 前端请求体类型不匹配，比如对象数组无法转化为指定对象
     * @param e
     * @return
     */
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> httpMessageNotReadableException (Exception e) {
        log.error("HttpMessageNotReadableException:", e);
        return Result.fail(e.getCause().getMessage());
    }



}

