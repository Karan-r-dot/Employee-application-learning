package com.example.employee_application.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.employee_application.Entity.Employee;
import com.example.employee_application.Entity.EmployeeRequestDto;
import com.example.employee_application.Entity.EmployeeResponseDto;
import com.example.employee_application.Service.EmployeeService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    } 
    
    @PostMapping("/createEmployee")
    public Employee createEmployeeNew(@Valid @RequestBody Employee employee) {
        
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
     
        return employeeService.getEmployeebyId(id);
    }
    
    @GetMapping("/findall")
    public List<Employee> findAllEmployees(){

        return employeeService.findAllEmployees();
    }

    @PutMapping("/updateEmployee/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable Long  id,@RequestBody EmployeeRequestDto employeeRequestDto){

        return employeeService.updateEmployee(id, employeeRequestDto);
        
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        
         employeeService.deleteEmployee(id);
         return "Employee deleted successfully";
    }
}
