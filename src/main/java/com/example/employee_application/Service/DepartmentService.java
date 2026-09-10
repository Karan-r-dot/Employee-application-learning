package com.example.employee_application.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.employee_application.Constants.EmployeeConstants;
import com.example.employee_application.Entity.Department;
import com.example.employee_application.Entity.DepartmentRequestDto;
import com.example.employee_application.Entity.DepartmentResponseDto;
import com.example.employee_application.Exception.CustomException;
import com.example.employee_application.Repository.DepartmentRepository;

@Service
public class DepartmentService {

    private final ModelMapper modelmapper;

    private final DepartmentRepository departmentRepository;

    // private final KafkaProducerService kafkaProducerService;

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    DepartmentService(ModelMapper modelmapper, DepartmentRepository departmentRepository) {
        this.modelmapper = modelmapper;
        this.departmentRepository = departmentRepository;
       
        
    }

    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {

        logger.info("Creating department with email: {}",departmentRequestDto.getDepartmentEmail());
        
        if(departmentRepository.existsByDepartmentEmail(departmentRequestDto.getDepartmentEmail())){

        logger.error("Department already exist with email:{}",departmentRequestDto.getDepartmentEmail());
            throw new CustomException(EmployeeConstants.DP002, EmployeeConstants.DEPARTMENT_EMAIL_ALREADY_EXISTS);
        }

        Department  department = modelmapper.map(departmentRequestDto,Department.class);
        Department saveDepartment = departmentRepository.save(department);
        // kafkaProducerService.sendDepartmentCreatedEvent(saveDepartment.getId());
        logger.info("Department created successfully with email:{}",saveDepartment.getDepartmentEmail());

        return modelmapper.map(saveDepartment,DepartmentResponseDto.class);
    }

    @Cacheable(value="departments",key = "#id")
    public DepartmentResponseDto findDepartmentById(Long id) {
       
       Department department = departmentRepository.findById(id).orElseThrow(() -> new CustomException(EmployeeConstants.DP001,EmployeeConstants.DEPARTMENT_NOT_FOUND));
       return modelmapper.map(department,DepartmentResponseDto.class);
    }

    public List<DepartmentResponseDto> findDepartmentByLocation(String location) {
    
        List<Department> departments = departmentRepository.findByDepartmentLocation(location);

        if(departments.isEmpty()){
            throw new CustomException(EmployeeConstants.DP003, EmployeeConstants.NO_DEPARTMENT_FOUND_FOR_LOCATION);
        }

        return departments.stream().map(department -> modelmapper.map(department,DepartmentResponseDto.class)).toList();

    }



}
