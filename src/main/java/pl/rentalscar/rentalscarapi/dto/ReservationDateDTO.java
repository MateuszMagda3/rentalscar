package pl.rentalscar.rentalscarapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDateDTO {
    private LocalDate pickupDate;
    private LocalDate returnDate;
}
