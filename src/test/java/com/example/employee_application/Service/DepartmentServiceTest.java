package com.example.employee_application.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.example.employee_application.Constants.EmployeeConstants;
import com.example.employee_application.Entity.Department;
import com.example.employee_application.Entity.DepartmentRequestDto;
import com.example.employee_application.Entity.DepartmentResponseDto;
import com.example.employee_application.Exception.CustomException;
import com.example.employee_application.Repository.DepartmentRepository;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Mock 
    private ModelMapper modelmapper;

    @Mock
    private DepartmentRepository departmentRepository;

    @Test
    void testFindDepartmentById_Success() {
        
        Long id = 1L;
        Department department = new Department();
        department.setId(id);
        
        DepartmentResponseDto responseDto = new DepartmentResponseDto();
        responseDto.setId(id);
        when(departmentRepository.findById(id)).thenReturn(Optional.of(department));
        when(modelmapper.map(department, DepartmentResponseDto.class)).thenReturn(responseDto);

        DepartmentResponseDto result = departmentService.findDepartmentById(id);
        assertEquals(id, result.getId());
    }

    @Test
    void testFindDepartmentById_NotFound() {

    Long id = 100L;

    when(departmentRepository.findById(id))
            .thenReturn(Optional.empty());

    CustomException exception = assertThrows(
            CustomException.class,
            () -> departmentService.findDepartmentById(id)
    );

    assertEquals(EmployeeConstants.DP001, exception.getErrorCode());
    }

    @Test
    void testCreateDepartment_Success() {

    DepartmentRequestDto requestDto = new DepartmentRequestDto();
    requestDto.setDepartmentEmail("it@test.com");

    Department department = new Department();
    department.setDepartmentEmail("it@test.com");

    DepartmentResponseDto responseDto = new DepartmentResponseDto();
    responseDto.setDepartmentEmail("it@test.com");

    when(departmentRepository.existsByDepartmentEmail("it@test.com"))
            .thenReturn(false);

    when(modelmapper.map(requestDto, Department.class))
            .thenReturn(department);

    when(departmentRepository.save(department))
            .thenReturn(department);

    when(modelmapper.map(department, DepartmentResponseDto.class))
            .thenReturn(responseDto);

    DepartmentResponseDto result =
            departmentService.createDepartment(requestDto);

    assertEquals("it@test.com", result.getDepartmentEmail());
    }

    @Test
    void testCreateDepartment_EmailAlreadyExists() {

    DepartmentRequestDto requestDto = new DepartmentRequestDto();
    requestDto.setDepartmentEmail("it@test.com");

    when(departmentRepository.existsByDepartmentEmail("it@test.com"))
            .thenReturn(true);

    CustomException exception = assertThrows(
            CustomException.class,
            () -> departmentService.createDepartment(requestDto)
    );

    assertEquals(EmployeeConstants.DP002, exception.getErrorCode());
    }

    @Test
    void testFindDepartmentByLocation_Success() {

    String location = "Chennai";

    Department department = new Department();
    department.setDepartmentLocation(location);

    DepartmentResponseDto responseDto = new DepartmentResponseDto();
    responseDto.setDepartmentLocation(location);

    when(departmentRepository.findByDepartmentLocation(location))
            .thenReturn(List.of(department));

    when(modelmapper.map(department, DepartmentResponseDto.class))
            .thenReturn(responseDto);

    List<DepartmentResponseDto> result =
            departmentService.findDepartmentByLocation(location);

    assertEquals(1, result.size());
    assertEquals("Chennai",
            result.get(0).getDepartmentLocation());
    }

    @Test
    void testFindDepartmentByLocation_NotFound() {

    String location = "Chennai";

    when(departmentRepository.findByDepartmentLocation(location))
            .thenReturn(Collections.emptyList());

    CustomException exception = assertThrows(
            CustomException.class,
            () -> departmentService.findDepartmentByLocation(location)
    );

    assertEquals(EmployeeConstants.DP003,
            exception.getErrorCode());
    }
}
