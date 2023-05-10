package fadhilakhmad.employeemanagement.project;

import fadhilakhmad.employeemanagement.employee.Employee;
import fadhilakhmad.employeemanagement.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    EmployeeRepository employeeRepository;

    List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project assignEmployee(int projectId, int employeeId) {
        //        Optional<Project> project = projectRepository.findById(projectId);
//        Optional<Employee> employee = employeeRepository.findById(employeeId);
//        project.ifPresent(value -> value.assignEmployee(employee.get()));
//        return projectRepository.save(project.get());
        Project project = projectRepository.findById(projectId).get();
        Employee employee = employeeRepository.findById(employeeId).get();
        project.assignEmployee(employee);
        return projectRepository.save(project);
    }
}
