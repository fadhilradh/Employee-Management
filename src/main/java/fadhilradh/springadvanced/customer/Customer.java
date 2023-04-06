package fadhilradh.springadvanced.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Customer {
    public interface PostValidation {}
    public interface PutValidation {}

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private int id;

    @NotBlank(message = "name must not be empty", groups = PostValidation.class)
    private String name;

    @NotBlank(message = "password must not be empty", groups = PostValidation.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "email must not be empty", groups = PostValidation.class)
    @Email(message = "email must be valid", groups = {PutValidation.class, PostValidation.class})
    private String email;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    @JsonProperty("customer_id")
    public int getCustomerId() {
        return id;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
