package fadhilakhmad.employeemanagement.project;

import fadhilakhmad.employeemanagement.employee.Employee;
import fadhilakhmad.employeemanagement.employee.EmployeeRepository;
import fadhilakhmad.employeemanagement.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("api/v1/projects")
@Validated
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    List<Project> getProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    Project createProject(@Valid @RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/{projectId}/employees/{employeeId}")
    Project assignEmployeesToProject(
            @PathVariable int projectId,
            @PathVariable int employeeId
    ) {

        return projectService.assignEmployee(projectId, employeeId);
    }
}
