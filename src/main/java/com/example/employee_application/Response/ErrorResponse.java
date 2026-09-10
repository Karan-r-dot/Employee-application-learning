package com.example.employee_application.Response;

import lombok.Getter;
import lombok.Setter;

//This like a DTO class to return it as a JSON Response 
@Getter
@Setter
public class ErrorResponse {
    
    private String errorCode;
    private String errorMessage;

    public ErrorResponse(String errorCode, String errorMessage) {
      this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    }



}
