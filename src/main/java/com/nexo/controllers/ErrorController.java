package com.nexo.controllers;

import com.nexo.models.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> methodErrorInfoResponseEntity(HttpServletRequest request,
                                                                   MethodArgumentNotValidException e ) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrorList = result.getFieldErrors();

        // convert error standard to normalize
        StringBuilder stringBuilder = new StringBuilder();
        fieldErrorList.forEach(f -> stringBuilder.append(f.getField() + " "+ f.getDefaultMessage() + " "));

        // return error info object with standard json
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), fieldErrorList.toString(), request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}
