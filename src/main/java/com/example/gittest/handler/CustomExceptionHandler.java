package com.example.gittest.handler;

import com.example.gittest.exception.CustomException;
import com.example.gittest.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseVo handelCustomException(CustomException customException) {
        log.error("handelCustomException {}", customException.getErrorMessage());
        return new ResponseVo(false, customException.getErrorCode(), customException.getErrorMessage());
    }
}
