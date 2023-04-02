package fadhilradh.springadvanced.customer;

import fadhilradh.springadvanced.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
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
        if(customer.isEmpty()) throw new NotFoundException("Customer not found");
        return ResponseEntity.status(HttpStatus.FOUND).body(customer);
    }

    ResponseEntity<Customer> postCustomer(Customer customerRequest) {
        Customer customer = new Customer();
        customer.setId(customerRequest.getId());
        customer.setName(customerRequest.getName());
        customer.setPassword(customerRequest.getPassword());
        customer.setEmail(customerRequest.getEmail());
        customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    void putCustomer(CustomerControllerV2.CustomerRequest customerRequest) {

        System.out.println(customerRequest);
//            Customer customer = new Customer();
//
//            customer.setId(customerRequest.id());
//            customer.setName(customerRequest.name());
//            customer.setPassword(customerRequest.password());
////            customerRepository.save(customer);
//            return ResponseEntity.ok();

    }
}
