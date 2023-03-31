package fadhilradh.springadvanced.customer;

import org.springframework.stereotype.Component;

import java.util.List;

public interface CustomerRepo {
    public List<Customer> getCustomers();
}
