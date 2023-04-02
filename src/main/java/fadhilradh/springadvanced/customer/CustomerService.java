package fadhilradh.springadvanced.customer;

import org.springframework.beans.factory.annotation.Autowired;
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

    Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    void postCustomer(Customer customerRequest) {
        System.out.println(customerRequest);
//        Customer customer = new Customer();
//        customer.setId(customerRequest.id());
//        customer.setName(customerRequest.name());
//        customer.setPassword(customerRequest.password());
//        customerRepository.save(customer);
//
//        return ResponseEntity.ok(customer);
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
