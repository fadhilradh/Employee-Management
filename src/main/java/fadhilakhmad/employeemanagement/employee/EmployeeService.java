package fadhilakhmad.employeemanagement.employee;

import fadhilakhmad.employeemanagement.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    ResponseEntity<Optional<Employee>> getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            log.error("employee with id : {} not found", id);
            throw new NotFoundException("Employee with id :" + id + " not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    ResponseEntity<Employee> postEmployee(Employee employeeRequest) {
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employeeRepository.save(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    ResponseEntity<Employee> putEmployee(int id, Employee employeeRequest) {
        Optional<Employee> employeeData = employeeRepository.findById(id);
        if (employeeData.isEmpty()) {
            throw new NotFoundException("Employee with id " + id + " not found!");
        }
        if (employeeRequest.getEmail() != null)  {
            employeeData.get().setEmail(employeeRequest.getName());
        }
        if (employeeRequest.getName() != null) {
            employeeData.get().setName(employeeRequest.getName());
        }
        employeeRepository.save(employeeData.get());
        return ResponseEntity.status(HttpStatus.OK).body(employeeData.get());

    }

    public void deleteEmployee(int employeeId) {
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);
        if (employeeData.isEmpty()) {
            throw new NotFoundException("Employee with id " + employeeId + " not found!");
        }

        employeeRepository.deleteById(employeeId);
        ResponseEntity.status(HttpStatus.OK);
    };

}
