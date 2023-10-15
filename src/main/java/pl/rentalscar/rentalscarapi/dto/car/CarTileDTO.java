package pl.rentalscar.rentalscarapi.dto.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarTileDTO {
    private Long id;
    private String make;
    private String model;
    private String photo;
    private Double minPrice;
}
