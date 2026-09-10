package com.example.employee_application.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_application.Entity.DepartmentRequestDto;
import com.example.employee_application.Entity.DepartmentResponseDto;
import com.example.employee_application.Service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    @PostMapping("/createdepartment")
    public DepartmentResponseDto createDepartment(@Valid @RequestBody DepartmentRequestDto  departmentRequestDto){

        return departmentService.createDepartment(departmentRequestDto);
    }

    @GetMapping("/findbyId/{id}")
    public DepartmentResponseDto findDepartmentById(@PathVariable Long id){
        
        return departmentService.findDepartmentById(id);
        
    }

    @GetMapping("/searchByLocation/{location}")
    public List<DepartmentResponseDto> findDepartmentByLocation(@PathVariable String location){

        return departmentService.findDepartmentByLocation(location);
    }
    

}
