package com.example.employee_application.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCountResponseDto {

    private String departmentName;
    private long projectCount;
}
