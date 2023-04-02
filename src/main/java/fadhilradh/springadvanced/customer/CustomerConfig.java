package fadhilradh.springadvanced.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Value("#{new Boolean('${app.useFakeCustomerRepo:false}')}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("command liner here world");
        };
    }

//    @Bean
//    CustomerRepo customerRepo() {
//        System.out.println("useFakeCustRepo : " + useFakeCustomerRepo);
//        return useFakeCustomerRepo
//                ? new CustomerFakeRepository()
//                : new CustomerRepository();
//    }
}
