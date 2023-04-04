package fadhilradh.springadvanced.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceholderConfig {
    @Bean("jsonplaceholder")
    CommandLineRunner runner(JSONPlaceholderClient client) {
        return args -> {
            System.out.println(
                    client.getPosts().size()
            );
            System.out.println(client.getPost(1));
        };
    }
}
