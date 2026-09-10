package com.example.employee_application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_application.Entity.Employee;
import com.example.employee_application.Entity.ProjectAssignment;
import com.example.employee_application.Repository.EmployeeRepository;
import com.example.employee_application.Repository.ProjectAssignmentRepository;

@Service
public class QueryService {

    private final EmployeeRepository employeeRepository;
    private final ProjectAssignmentRepository projectAssignmentRepository;

    QueryService(EmployeeRepository employeeRepository, ProjectAssignmentRepository projectAssignmentRepository) {
        this.employeeRepository = employeeRepository;
        this.projectAssignmentRepository = projectAssignmentRepository;
    }

    public List<Employee> findAll() {
        
        return employeeRepository.findAll();
    }

    //@Cacheable(value = "projectassignment",key = "#employeeId")
    public List<ProjectAssignment> findAssignmentHistoryByEmployeeId(Long employeeId) {
        
        return projectAssignmentRepository.findAssignmentHistoryByEmployeeId(employeeId);
    }

    

}
