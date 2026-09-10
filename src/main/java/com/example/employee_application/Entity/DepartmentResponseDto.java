package com.example.employee_application.Entity;

import lombok.Data;

@Data
public class DepartmentResponseDto {

    private Long id;
    private String departmentName;
    private String departmentLocation;
    private String departmentEmail;

}
