package com.example.employee_application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employee_application.Entity.ProjectAssignment;

@Repository
public interface ProjectAssignmentRepository extends JpaRepository<ProjectAssignment,Long>,JpaSpecificationExecutor<ProjectAssignment>{

    @Query("SELECT pa FROM ProjectAssignment pa WHERE pa.employee.id = :employeeId ORDER BY pa.assignedDate DESC")
    List<ProjectAssignment> findAssignmentHistoryByEmployeeId(@Param("employeeId") Long employeeId);

}
