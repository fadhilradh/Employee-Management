package fadhilradh.springadvanced.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1, "Abu Bakr"),
                new Customer(2, "Umar")
        );
    }
}
