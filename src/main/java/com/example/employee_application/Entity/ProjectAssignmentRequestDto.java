package com.example.employee_application.Entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectAssignmentRequestDto {

    @NotNull(message = "Employee Id is mandatory")
    private Long employeeId;

    @NotNull(message = "Project Id is mandatory")
    private Long projectId;
}
