package com.example.employee_application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_application.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

    boolean existsByDepartmentEmail(String departmentEmail);

    List<Department> findByDepartmentLocation(String departmentLocation);

}
