package pl.rentalscar.rentalscarapi.dto.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarRateDTO {
    private Integer minDays;
    private Integer maxDays;
    private Double dailyRate;
}
