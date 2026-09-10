package com.example.employee_application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_application.Entity.ProjectCountResponseDto;
import com.example.employee_application.Entity.ProjectRequestDto;
import com.example.employee_application.Entity.ProjectResponseDto;
import com.example.employee_application.Service.ProjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/createProject")
    public ProjectResponseDto createProject(@RequestBody ProjectRequestDto projectRequestDto){

        return projectService.createProject(projectRequestDto);

    }

    @GetMapping("/getprojectsbyid/{departmentId}")
    public List<ProjectResponseDto> getProjectsByDepartmentId(@PathVariable Long departmentId){
        
        return projectService.getProjectsByDepartmentId(departmentId);
    }

    @GetMapping("/search")
    public List<ProjectResponseDto> searchProjects(@RequestParam(required = false)Long departmentId ,
                                    @RequestParam(required = false) String projectCode){
        return projectService.searchProjects(departmentId,projectCode);


    }
  
    /*In this API we implemented Pagination with starting page number 1 , shows only 5 records per page
    and we implemented sorting by sorting the records by projectname and sorting direction to be either ascending
    or descending */
    @GetMapping("/all")
    public Page<ProjectResponseDto> getAllProjects(@RequestParam(defaultValue = "0")int page, 
                                    @RequestParam(defaultValue = "5")int size,
                                    @RequestParam(defaultValue = "projectName")String sortBy,
                                    @RequestParam(defaultValue="desc")String direction){

        return projectService.getAllProjects(page, size,sortBy,direction);
    }

    @GetMapping("/count/department/{departmentId}")
    public ProjectCountResponseDto getProjectCountByDepartment(@PathVariable Long departmentId){

        return projectService.getProjectCountByDepartment(departmentId);
    }
}
    

