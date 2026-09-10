package com.example.employee_application.Entity;

import lombok.Data;

@Data
public class EmployeeResponseDto {

    private Long id;
    private String name;
    private String department;
    private Double salary;

}
