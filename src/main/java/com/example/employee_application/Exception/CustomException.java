package com.example.employee_application.Exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

    private final String errorCode;

    public CustomException(String errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
    }

}


