package fadhilakhmad.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeManagement {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagement.class, args);
    }
}
