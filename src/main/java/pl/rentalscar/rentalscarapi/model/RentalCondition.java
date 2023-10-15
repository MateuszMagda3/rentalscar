package pl.rentalscar.rentalscarapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Set;

/**
 * Represents rental conditions for cars in the car rental system.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class RentalCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Description cannot be null")
    @Size(min = 10, max = 255, message = "Description should be between 10 and 255 characters")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "rentalConditions")
    private Set<Car> cars;
}