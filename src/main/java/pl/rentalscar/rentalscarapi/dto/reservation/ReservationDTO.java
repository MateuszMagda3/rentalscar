package pl.rentalscar.rentalscarapi.dto.reservation;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationDTO {
    private Long carId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;
}
