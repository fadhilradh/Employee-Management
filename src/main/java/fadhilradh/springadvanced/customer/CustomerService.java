package fadhilradh.springadvanced.customer;

import fadhilradh.springadvanced.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    ResponseEntity<Optional<Customer>> getCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            log.error("customer with id : {} not found", id);
            throw new NotFoundException("Customer with id :" + id + " not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    ResponseEntity<Customer> postCustomer(Customer customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setPassword(customerRequest.getPassword());
        customer.setEmail(customerRequest.getEmail());
        customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    ResponseEntity<Customer> putCustomer(int id, Customer customerRequest) {
        Optional<Customer> customerData = customerRepository.findById(id);
        if (customerData.isEmpty()) {
            throw new NotFoundException("Customer with id " + id + " not found!");
        }
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setPassword(customerRequest.getPassword());
        customer.setEmail(customerRequest.getEmail());
        customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.OK).body(customer);

    }
}
