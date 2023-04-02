package fadhilradh.springadvanced.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/v1/customers")
@Deprecated
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomer() {
        return customerService.getCustomers();
    }

    @PostMapping
    Customer postNewCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        return customer;
    }
}