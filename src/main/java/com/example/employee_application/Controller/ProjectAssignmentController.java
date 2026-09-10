package com.example.employee_application.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_application.Entity.ProjectAssignmentRequestDto;
import com.example.employee_application.Entity.ProjectAssignmentResponseDto;
import com.example.employee_application.Entity.ProjectAssignmentSearchDto;
import com.example.employee_application.Service.ProjectAssignmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/assignment")
@RequiredArgsConstructor
public class ProjectAssignmentController {

    private final ProjectAssignmentService projectAssignmentService;

    @PostMapping("create")
    public ProjectAssignmentResponseDto createProjectAssignment(@Valid @RequestBody ProjectAssignmentRequestDto projectAssignmentRequestDto){

        return projectAssignmentService.createProjectAssignment(projectAssignmentRequestDto);
    }

    @GetMapping("/history/{employeeId}")
    public List<ProjectAssignmentResponseDto> getEmployeeAssignmentHistory(@PathVariable Long employeeId){

        return projectAssignmentService.getEmployeeAssignmentHistory(employeeId);
    }

    @PostMapping("/search")
    public List<ProjectAssignmentResponseDto> searchAssignments(@RequestBody ProjectAssignmentSearchDto projectAssignmentSearchDto){

        return projectAssignmentService.searchAssignments(projectAssignmentSearchDto);
    }

}
