package com.example.employee_application.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDto {

    private Long projectId;
    private String projectName;
    private String projectCode;
    private String departmentName;

}
