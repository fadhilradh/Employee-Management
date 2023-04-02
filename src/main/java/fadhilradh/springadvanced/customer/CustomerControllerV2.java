package fadhilradh.springadvanced.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("api/v2/customers")
public class CustomerControllerV2 {
    private final CustomerService customerService;

    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    record CustomerRequest(int id, String name, String password, String email) {}

    @GetMapping
    List<Customer> getCustomer() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable("customerId") int id) {
       return customerService.getCustomerById(id);
    }

    @PostMapping
    ResponseEntity<Customer> postNewCustomer(@Valid @RequestBody  Customer customerRequest) {
       return customerService.postCustomer(customerRequest);
    }
}