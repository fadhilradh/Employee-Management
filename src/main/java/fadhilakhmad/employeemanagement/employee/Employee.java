package fadhilakhmad.employeemanagement.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import fadhilakhmad.employeemanagement.project.Project;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Employee {
    public interface PostValidation {}
    public interface PutValidation {}

    @Id
    @SequenceGenerator(
            name = "employee_id_sequence",
            sequenceName = "employee_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_sequence"
    )
    private int id;

    @NotBlank(message = "name must not be empty", groups = PostValidation.class)
    private String name;

    @NotBlank(message = "email must not be empty", groups = PostValidation.class)
    @Email(message = "email must be valid", groups = {PutValidation.class, PostValidation.class})
    private String email;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedEmployees")
    @ToString.Exclude
    private Set<Project> projects;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Set<Project> getProjects() {
        return projects;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @JsonProperty("employee_id")
    public int getEmployeeId() {
        return id;
    }
}
