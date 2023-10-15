package pl.rentalscar.rentalscarapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

import pl.rentalscar.rentalscarapi.model.ReservationStatus;

/**
 * Represents a reservation of a car in the car rental system.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    @NotNull(message = "Car for reservation cannot be null")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull(message = "Customer for reservation cannot be null")
    private Customer customer;

    @NotNull(message = "Date of booking cannot be null")
    private LocalDateTime dateOfBooking;

    @NotNull(message = "Start date of reservation cannot be null")
    @Future(message = "Start date of reservation should be in the future")
    private LocalDate startDate;

    @NotNull(message = "End date of reservation cannot be null")
    @Future(message = "End date of reservation should be in the future")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

}