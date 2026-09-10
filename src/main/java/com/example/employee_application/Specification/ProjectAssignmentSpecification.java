package com.example.employee_application.Specification;

import org.springframework.data.jpa.domain.Specification;

import com.example.employee_application.Entity.ProjectAssignment;

public class ProjectAssignmentSpecification {

    public static Specification<ProjectAssignment> hasEmployeeId(Long employeeId){

        return (root,query,criteriaBuilder) -> 
                   criteriaBuilder.equal(root.get("employee").get("id"), employeeId);
    }

    public static Specification<ProjectAssignment> hasProjectId(Long projectId) {
        return (root, query, criteriaBuilder) ->
                   criteriaBuilder.equal(root.get("project").get("id"),projectId);
    }

     public static Specification<ProjectAssignment> hasStatus(String status) {
        return (root, query, criteriaBuilder) ->
                   criteriaBuilder.equal(root.get("status"),status);

}

}
