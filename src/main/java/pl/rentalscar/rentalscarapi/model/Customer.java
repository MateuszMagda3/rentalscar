package pl.rentalscar.rentalscarapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name should be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, max = 50, message = "Last name should be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Phone number cannot be null")
    @Size(min = 9, max = 15, message = "Phone number should be between 9 and 15 characters") // Zakładam, że numer telefonu ma co najmniej 9 znaków
    @Pattern(regexp = "\\+?[0-9]+", message = "Phone number can contain only numbers and an optional plus at the beginning")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Reservation> reservations;
}
