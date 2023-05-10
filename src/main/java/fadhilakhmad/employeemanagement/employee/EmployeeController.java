package fadhilakhmad.employeemanagement.employee;

import fadhilakhmad.employeemanagement.exception.ApiReqException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("api/v1/employees")
@Validated
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    List<Employee> getEmployee() {
        return employeeService.getEmployees();
    }

    @GetMapping("exception")
    List<Employee> getEmployeeException() {
        throw new ApiReqException("Api req exception for employee");
    }

    @GetMapping(path = "{employeeId}")
    ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("employeeId") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    @Validated(Employee.PostValidation.class)
    ResponseEntity<Employee> postNewEmployee(@Valid @RequestBody Employee employeeRequest) {
        return employeeService.postEmployee(employeeRequest);
    }

    @PutMapping(path = "{employeeId}")
    @Validated(Employee.PutValidation.class)
    ResponseEntity<Employee> putEmployee(@PathVariable("employeeId") int id, @Valid @RequestBody Employee employeeRequest) {
        return employeeService.putEmployee(id, employeeRequest);
    }

    @DeleteMapping(path = "{employeeId}")
    void deleteEmployee(@PathVariable("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}