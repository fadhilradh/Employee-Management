package fadhilradh.springadvanced.customer;

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
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository ;
    private CustomerService testCustomerService;

    @BeforeEach
    void setUp() {
        this.testCustomerService = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer umar = new Customer(1, "Umar", "123", "umar@umail.com");
        Customer salma = new Customer(2, "Salma", "123", "salma@umail.com");
        customerRepository.saveAll(Arrays.asList(umar, salma));

        List<Customer> customers = testCustomerService.getCustomers();

        assertEquals(2, customers.size());
    }

    @Test
    void getCustomerById() {
        Customer umar = new Customer(1, "Umar", "123", "umar@umail.com");
        Optional<Customer> umarOpt = Optional.of(umar);

        customerRepository.save(umar);

        ResponseEntity<Optional<Customer>> customerTestResponse = testCustomerService.getCustomerById(1);
        ResponseEntity<Optional<Customer>> successResponse = ResponseEntity.status(HttpStatus.OK).body(umarOpt);

        assertEquals(successResponse, customerTestResponse);
    }
}