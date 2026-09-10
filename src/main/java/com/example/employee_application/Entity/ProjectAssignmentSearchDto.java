package com.example.employee_application.Entity;

import lombok.Data;

@Data
public class ProjectAssignmentSearchDto {

    // Filter assignments for a specific employee
    // Example: employeeId = 2 (Karan)
     private Long employeeId;

    // Filter assignments for a specific project
    // Example: projectId = 1 (Banking Project)
    private Long projectId;

    // Filter assignments based on status
    // Example: ACTIVE, COMPLETED
    private String status;

}
