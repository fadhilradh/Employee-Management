package fadhilakhmad.employeemanagement.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProjectServiceTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    private EmployeeService testEmployeeService;

    @BeforeEach
    void setUp() {
        this.testEmployeeService = new EmployeeService(employeeRepository);
    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    void getEmployees() {
        Employee umar = new Employee(1, "Umar", "123", "umar@umail.com");
        Employee salma = new Employee(2, "Salma", "123", "salma@umail.com");
        employeeRepository.saveAll(Arrays.asList(umar, salma));

        List<Employee> employees = testEmployeeService.getEmployees();

        assertEquals(2, employees.size());
    }

    @Test
    void getEmployeeById() {
        Employee umar = new Employee(1, "Umar", "123", "umar@umail.com");
        Optional<Employee> umarOpt = Optional.of(umar);

        employeeRepository.save(umar);

        ResponseEntity<Optional<Employee>> employeeTestResponse = testEmployeeService.getEmployeeById(1);
        ResponseEntity<Optional<Employee>> successResponse = ResponseEntity.status(HttpStatus.OK).body(umarOpt);

        assertEquals(successResponse, employeeTestResponse);
    }
}