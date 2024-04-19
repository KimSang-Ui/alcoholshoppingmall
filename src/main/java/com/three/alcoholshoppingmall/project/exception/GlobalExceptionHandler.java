package com.three.alcoholshoppingmall.project.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BizException.class)
    public final ResponseEntity<ErrorReponse> handleException(BizException e){
        ErrorReponse errorReponse = ErrorReponse.builder()
                .errorMessage(e.getErrorCode().getMessage())
                .errorCode(e.getErrorCode().getErrorCode())
                .errorDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(errorReponse);
    }
}
