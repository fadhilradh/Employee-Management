package fadhilradh.springadvanced.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Customer {
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
    @NotBlank(message = "name must not be empty")
    private String name;
    @NotBlank(message = "password must not be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @NotBlank(message = "email must not be empty")
    @Email(message = "email must be valid")
    private String email;

    public Customer(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("customer_id")
    public int getCustomerId() {
        return id;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }
}
