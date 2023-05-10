package fadhilakhmad.employeemanagement.project;

import fadhilakhmad.employeemanagement.employee.Employee;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @ToString
public class Project {
    @Id
    @SequenceGenerator(
            name = "project_id_sequence",
            sequenceName = "project_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_id_sequence"
    )
    private int id;

    @NotBlank(message = "project name must not be empty")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "employees_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> assignedEmployees = new HashSet<>();

    public void assignEmployee(Employee employee) {
        assignedEmployees.add(employee);
    }
}
