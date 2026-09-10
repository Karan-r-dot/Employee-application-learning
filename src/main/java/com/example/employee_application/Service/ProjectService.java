package com.example.employee_application.Service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.employee_application.Constants.EmployeeConstants;
import com.example.employee_application.Entity.Department;
import com.example.employee_application.Entity.Project;
import com.example.employee_application.Entity.ProjectCountResponseDto;
import com.example.employee_application.Entity.ProjectRequestDto;
import com.example.employee_application.Entity.ProjectResponseDto;
import com.example.employee_application.Exception.CustomException;
import com.example.employee_application.Repository.DepartmentRepository;
import com.example.employee_application.Repository.ProjectRepository;


@Service
public class ProjectService {

    private final DepartmentRepository departmentRepository ;
    private final ProjectRepository projectRepository;

    ProjectService(DepartmentRepository departmentRepository, ProjectRepository projectRepository) {
        this.departmentRepository = departmentRepository;
        this.projectRepository = projectRepository;
    }

    public ProjectResponseDto createProject(ProjectRequestDto projectRequestDto){

        Department department = departmentRepository.findById(projectRequestDto.getDepartmentId()).orElseThrow(() -> new CustomException(EmployeeConstants.DP001,EmployeeConstants.DEPARTMENT_NOT_FOUND));

        Project project = new Project();
        project.setProjectName(projectRequestDto.getProjectName());
        project.setProjectCode(projectRequestDto.getProjectName());
        project.setDepartment(department);
        Project savedProject = projectRepository.save(project);

        return new ProjectResponseDto(
                        savedProject.getId(),
                        savedProject.getProjectCode(),
                        savedProject.getProjectName(),
                        savedProject.getDepartment().getDepartment_Name()
                           );

    }

    public List<ProjectResponseDto> getProjectsByDepartmentId(Long departmentId){

        List<Project> projects = projectRepository.findByDepartmentId(departmentId);

        if(projects.isEmpty()){
            throw new CustomException(EmployeeConstants.P004,EmployeeConstants.PROJECT_NOT_FOUND);
        }
        
        return projects.stream().map(project -> new ProjectResponseDto(project.getId(),
                                                            project.getProjectName(),
                                                            project.getProjectCode(),
                                                            project.getDepartment().getDepartment_Name()
                                                                )).toList();
    }

    public List<ProjectResponseDto> searchProjects(Long departmentId, String projectCode) {
        
        if(departmentId!=null && projectCode!=null){
            
            List<Project> projects = projectRepository.findByDepartmentIdAndProjectCode(departmentId,projectCode);

            if(projects.isEmpty()){
                throw new CustomException(EmployeeConstants.P004,EmployeeConstants.PROJECT_NOT_FOUND);
            }

        return projects.stream().map(project -> new ProjectResponseDto(project.getId(),
                                            project.getProjectCode(),
                                            project.getProjectName(),
                                            project.getDepartment().getDepartment_Name())) 
                                            .toList();
        }

        if(departmentId!=null && projectCode == null){

            List<Project> projects = projectRepository.findByDepartmentId(departmentId);

            if(projects.isEmpty()){
                throw new CustomException(EmployeeConstants.P004,EmployeeConstants.PROJECT_NOT_FOUND);
            }

        return projects.stream().map(project -> new ProjectResponseDto(project.getId(),
                                            project.getProjectCode(),
                                            project.getProjectName(),
                                            project.getDepartment().getDepartment_Name())) 
                                            .toList();

        }

        if(departmentId == null && projectCode!=null){

            List<Project> projects = projectRepository.findByProjectCode(projectCode);

            if(projects.isEmpty()){
                throw new CustomException(EmployeeConstants.P004,EmployeeConstants.PROJECT_NOT_FOUND);
            }

        return projects.stream().map(project -> new ProjectResponseDto(project.getId(),
                                            project.getProjectCode(),
                                            project.getProjectName(),
                                            project.getDepartment().getDepartment_Name())) 
                                            .toList();
        }

        throw new CustomException(EmployeeConstants.P001,EmployeeConstants.ONE_PARAMETER_IS_REQUIRED);

        
    }

    public Page<ProjectResponseDto> getAllProjects(int page, int size, String sortBy, String direction) {
        
        /*In sortdirection in the equalsignorecase will allow "desc,Desc,DESC" and if the directionis desc it will go to first 
        sort.direction.desc or asc*/
        Sort.Direction sortDirection  = direction.equalsIgnoreCase("desc")?Sort.Direction.DESC :Sort.Direction.ASC;
        Sort sort = Sort.by(sortDirection,sortBy);
        Pageable pageable = PageRequest.of(page, size,sort);
        Page<Project> projects = projectRepository.findAll(pageable);
        return projects.map(project -> new ProjectResponseDto(project.getId(),
                                         project.getProjectName(),
                                        project.getProjectCode(),
                                        project.getDepartment().getDepartment_Name()
                                    ));
    }

    public ProjectCountResponseDto getProjectCountByDepartment(Long departmentId) {
        
        long projectCount = projectRepository.countByDepartmentId(departmentId);
        if(projectCount == 0){
            throw new CustomException(EmployeeConstants.P004,EmployeeConstants.PROJECT_NOT_FOUND);
        }
        
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                                                  new CustomException(EmployeeConstants.DP001, EmployeeConstants.DEPARTMENT_NOT_FOUND));

        return new ProjectCountResponseDto(department.getDepartment_Name(),projectCount);
       
    }

}
