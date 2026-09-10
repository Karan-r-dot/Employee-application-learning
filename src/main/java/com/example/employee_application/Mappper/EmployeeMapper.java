package com.example.employee_application.Mappper;

import com.example.employee_application.Entity.Employee;
import com.example.employee_application.Entity.EmployeeResponseDto;

public class EmployeeMapper {

    public static EmployeeResponseDto toEmployeeResponseDto(Employee employee){
        
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setName(employee.getName());
        employeeResponseDto.setDepartment(employee.getDepartment());
        employeeResponseDto.setSalary(employee.getSalary());
        
        return employeeResponseDto; 
    }

}
