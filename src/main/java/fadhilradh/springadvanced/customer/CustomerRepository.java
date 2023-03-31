package fadhilradh.springadvanced.customer;


import java.util.Collections;
import java.util.List;

public class CustomerRepository implements CustomerRepo{
    // TODO : connect to DB
    @Override
    public List<Customer> getCustomers() {
        return Collections.singletonList(new Customer(1, "todo: Implement DB"));
    }
}
