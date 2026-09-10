package com.example.employee_application.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.employee_application.Constants.EmployeeConstants;
import com.example.employee_application.Entity.Employee;
import com.example.employee_application.Entity.Project;
import com.example.employee_application.Entity.ProjectAssignment;
import com.example.employee_application.Entity.ProjectAssignmentRequestDto;
import com.example.employee_application.Entity.ProjectAssignmentResponseDto;
import com.example.employee_application.Entity.ProjectAssignmentSearchDto;
import com.example.employee_application.Exception.CustomException;
import com.example.employee_application.Repository.EmployeeRepository;
import com.example.employee_application.Repository.ProjectAssignmentRepository;
import com.example.employee_application.Repository.ProjectRepository;
import com.example.employee_application.Specification.ProjectAssignmentSpecification;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectAssignmentService {

    private final ProjectAssignmentRepository projectAssignmentRepository;

    private final EmployeeRepository employeeRepository;

    private final ProjectRepository projectRepository;

    private final QueryService queryService;

    public List<ProjectAssignmentResponseDto> getEmployeeAssignmentHistory(Long employeeId) {
        
        List<ProjectAssignment> assignments = queryService.findAssignmentHistoryByEmployeeId(employeeId);

        return assignments.stream().map(assignment -> new ProjectAssignmentResponseDto(assignment.getId(),
                                                           assignment.getEmployee().getName(),
                                                           assignment.getProject().getProjectName(),
                                                          assignment.getAssignedDate(),
                                                          assignment.getRelievedDate(),
                                                        assignment.getStatus())).toList();

    }

    public ProjectAssignmentResponseDto createProjectAssignment(
            ProjectAssignmentRequestDto projectAssignmentRequestDto) {

                Employee employee = employeeRepository.findById(projectAssignmentRequestDto.getEmployeeId()).orElseThrow(
                                                     () -> new CustomException(EmployeeConstants.E001,EmployeeConstants.EMPLOYEE_NOT_FOUND));

                Project project = projectRepository.findById(projectAssignmentRequestDto.getProjectId()).orElseThrow(() ->
                                                      new CustomException(EmployeeConstants.P004,EmployeeConstants.PROJECT_NOT_FOUND));

                ProjectAssignment projectAssignment = new ProjectAssignment();
                projectAssignment.setEmployee(employee);
                projectAssignment.setProject(project);
                projectAssignment.setAssignedDate(LocalDate.now());
                projectAssignment.setRelievedDate(null);
                projectAssignment.setStatus("ACTIVE");
                ProjectAssignment savedAssignment = projectAssignmentRepository.save(projectAssignment);

                return new ProjectAssignmentResponseDto(savedAssignment.getId(),
                                         savedAssignment.getEmployee().getName(),
                                         savedAssignment.getProject().getProjectName(),
                                         savedAssignment.getAssignedDate(),
                                         savedAssignment.getRelievedDate(),
                                         savedAssignment.getStatus());
        
                                    }

    public List<ProjectAssignmentResponseDto> searchAssignments(ProjectAssignmentSearchDto projectAssignmentSearchDto) {
        
        
        Specification<ProjectAssignment> specification = null;

        if(projectAssignmentSearchDto.getEmployeeId()!=null){

            specification  = ProjectAssignmentSpecification.hasEmployeeId(projectAssignmentSearchDto.getEmployeeId());
        }

        if(projectAssignmentSearchDto.getProjectId()!=null){
            if(specification == null){
                specification =ProjectAssignmentSpecification.hasProjectId(projectAssignmentSearchDto.getProjectId());
            }else{
                specification = specification.and(ProjectAssignmentSpecification.hasProjectId(projectAssignmentSearchDto.getProjectId()));
            }
        }

        if(projectAssignmentSearchDto.getStatus()!=null){
            if(specification == null){
                specification =ProjectAssignmentSpecification.hasStatus(projectAssignmentSearchDto.getStatus());
            }else{
                specification = specification.and(ProjectAssignmentSpecification.hasStatus(projectAssignmentSearchDto.getStatus()));
            }
        }

        List<ProjectAssignment> assignments = projectAssignmentRepository.findAll(specification);

        return assignments.stream().map(assignment -> new ProjectAssignmentResponseDto(assignment.getId(),
                                                               assignment.getEmployee().getName(),
                                                               assignment.getProject().getProjectName(),
                                                              assignment.getRelievedDate(),
                                                              assignment.getAssignedDate(),
                                                              assignment.getStatus())).toList();
    }
}