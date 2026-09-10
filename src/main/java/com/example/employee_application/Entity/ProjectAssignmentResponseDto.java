package com.example.employee_application.Entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAssignmentResponseDto {

    private Long assignmentId;
    private String employeeName;
    private String projectName;
    private LocalDate assignedDate;
    private LocalDate relievedDate;
    private String status;
}
