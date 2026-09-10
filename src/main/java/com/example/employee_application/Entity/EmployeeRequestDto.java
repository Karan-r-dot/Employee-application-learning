package com.example.employee_application.Entity;

import lombok.Data;

@Data
public class EmployeeRequestDto {

    private String name;
    private String department;
    private Double salary;

}
