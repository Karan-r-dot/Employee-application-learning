package com.example.employee_application.Service;


import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import com.example.employee_application.Entity.Employee;
import com.example.employee_application.Entity.EmployeeRequestDto;
import com.example.employee_application.Entity.EmployeeResponseDto;
import com.example.employee_application.Mappper.EmployeeMapper;
import com.example.employee_application.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final QueryService queryService;

    EmployeeService(EmployeeRepository employeeRepository, QueryService queryService) {
        this.employeeRepository = employeeRepository;
        this.queryService = queryService;
    }


    public Employee createEmployee(Employee employee) {
        
        return employeeRepository.save(employee);

    }

    public Employee getEmployeebyId(Long id) {
       
        return employeeRepository.getById(id);
    }


    public List<Employee> findAllEmployees() {
        
        return queryService.findAll();
    }

    @CachePut(
    value = "employee",
    key = "#id")
    public EmployeeResponseDto updateEmployee(Long  id,EmployeeRequestDto employeeRequestDto){

       Employee employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));       
        
       employee.setName(employeeRequestDto.getName());
       employee.setDepartment(employeeRequestDto.getDepartment());
       employee.setSalary(employeeRequestDto.getSalary());

       Employee updatedEmployee = employeeRepository.save(employee);
       return EmployeeMapper.toEmployeeResponseDto(updatedEmployee);  
    }


    public void deleteEmployee(Long id) {
     
       employeeRepository.deleteById(id);
    }


}
