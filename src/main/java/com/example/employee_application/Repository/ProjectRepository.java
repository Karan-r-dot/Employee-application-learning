package com.example.employee_application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_application.Entity.Project;
import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> findByDepartmentId(Long departmentId);

    List<Project> findByDepartmentIdAndProjectCode(Long departmentId, String projectCode);

    List<Project> findByProjectCode(String projectCode);

    long countByDepartmentId(Long departmentId);

}
