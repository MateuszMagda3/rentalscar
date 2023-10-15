package pl.rentalscar.rentalscarapi.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Set;

/**
 * Represents a Car entity in the car rental system.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Make cannot be null")
    @Size(min=2, max=30, message = "Make should be between 2 and 30 characters")
    @Column(length = 30)
    private String make;

    @NotNull(message = "Model cannot be null")
    @Size(min=2, max=30, message = "Model should be between 2 and 30 characters")
    @Column(length = 30)
    private String model;

    @NotNull(message = "License plate cannot be null")
    @Size(min=6, max=10, message = "License plate should be between 6 and 10 characters")
    @Column(length = 10, unique = true)
    private String licensePlate;


    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;

    @NotNull
    @Min(2)
    @Max(5)
    private Integer numberOfDoors; // Zmiana z int na Integer

    @NotNull
    @Min(2)
    @Max(9)
    private Integer numberOfSeats;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @NotNull(message = "Production year cannot be null")
    @Min(1900)  // Przyjmijmy, że najwcześniejszy rok produkcji to 1900
    @Max(2100)  // Przyjmijmy, że najpóźniejszy rok produkcji to 2100
    private Integer productionYear;  // Pole reprezentujące rok produkcji

    @DecimalMin("0.5")
    private Double engineSize;


    @Size(max=255)
    @Column(length = 255)
    private String description;

    @OneToMany(mappedBy = "car", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Photo> photos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_list_id")
    private PriceList priceList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "carEquipment",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private Set<Equipment> equipment;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "carRentalCondition",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "rental_condition_id"))
    private Set<RentalCondition> rentalConditions;

    public enum TransmissionType {
        MANUAL, AUTOMATIC
    }

    public enum FuelType {
        PETROL, DIESEL, ELECTRIC, HYBRID
    }
}