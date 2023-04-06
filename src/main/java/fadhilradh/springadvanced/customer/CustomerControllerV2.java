package fadhilradh.springadvanced.customer;

import fadhilradh.springadvanced.exception.ApiReqException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("api/v2/customers")
@Validated
public class CustomerControllerV2 {
    private final CustomerService customerService;

    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomer() {
        return customerService.getCustomers();
    }

    @GetMapping("exception")
    List<Customer> getCustomerException() {
        throw new ApiReqException("Api req exception for customer");
    }

    @GetMapping(path = "{customerId}")
    ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable("customerId") int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    @Validated(Customer.PostValidation.class)
    ResponseEntity<Customer> postNewCustomer(@Valid @RequestBody Customer customerRequest) {
        return customerService.postCustomer(customerRequest);
    }

    @PutMapping(path = "{customerId}")
    @Validated(Customer.PutValidation.class)
    ResponseEntity<Customer> putCustomer(@PathVariable("customerId") int id, @Valid @RequestBody Customer customerRequest) {
        return customerService.putCustomer(id, customerRequest);
    }
}