package org.lyflexi.debug_basicjdk.exception.advice;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.lyflexi.debug_basicjdk.exception.ErrorType;
import org.lyflexi.debug_basicjdk.exception.LyFlexiBusinessException;
import org.lyflexi.debug_basicjdk.exception.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/23 8:16
 */
@Slf4j
public class DefaultGlobalExceptionHandlerAdvice {

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public Result<?> validationException (ValidationException e) {
        log.warn("ValidationException:", e);
        return Result.fail(e.getCause().getMessage());
    }

    @ExceptionHandler(value = { LyFlexiBusinessException.class})
    public Result<?> LyFlexiBusinessException (LyFlexiBusinessException lesBusinessEx) {
        log.warn("LyFlexiBusinessException:",lesBusinessEx);
        Result<?> result = Result.fail();
//        Result<?> result = new Result(lesBusinessEx.getErrorType())
//        result.setCode(lesBusinessEx.getErrorType().getCode());
        // 返回错误信息 TODO 返回错误信息国际化处理
        result.setMessage(buildReturnMessage(lesBusinessEx));
        return result;
    }

    private String buildReturnMessage(LyFlexiBusinessException lesBusinessEx) {
        String businessMessage = lesBusinessEx.getMessage();
        ErrorType errorType = lesBusinessEx.getErrorType();
        String mesg = errorType.getMesg();
        String code = errorType.getCode();
        Object[] args = lesBusinessEx.getArgs();
        // 参数不为空替换参数
        if (ObjectUtils.allNotNull(mesg, args)) {
            businessMessage = "【" + code + "】" + String.format(mesg, args);
        }
        return businessMessage;
    }


    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> exception (Exception e) {
        log.warn("Exception:", e);
        return Result.fail();
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> methodArgumentNotValidException (MethodArgumentNotValidException e) {
        log.warn("MethodArgumentNotValidException: ");
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            log.info("  字段名：{}", fieldName);
            log.info("  错误信息：{}", errorMessage);
            sb.append(errorMessage).append(" ");
        }
        return Result.fail(sb.toString());
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> throwable (Throwable e) {
        log.warn("Throwable:", e);
        return Result.fail();
    }
}