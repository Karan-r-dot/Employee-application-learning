package com.example.employee_application.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.employee_application.Response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex){

        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(),ex.getMessage());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);


    }

}
