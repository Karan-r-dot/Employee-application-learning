package com.example.employee_application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_application.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

   

}
