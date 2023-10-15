package pl.rentalscar.rentalscarapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * Represents a pricing list for car rentals.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 255, message = "Name should be between 10 and 255 characters")
    private String name;

    @OneToMany(mappedBy = "priceList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Rate> rates;

    @OneToMany(mappedBy = "priceList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Car> cars;
}
