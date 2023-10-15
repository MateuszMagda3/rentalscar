package pl.rentalscar.rentalscarapi.dto.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.rentalscar.rentalscarapi.dto.PhotoDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CarDetailsDTO {
    private Long id;
    private String make;
    private String model;
    private String description;
    private Double engineSize;
    private String fuelType;
    private Integer productionYear;
    private Integer numberOfDoors;
    private String transmissionType;
    private List<String> equipmentList;
    private List<String> rentalConditionList;
    private List<PhotoDTO> photoList;
    private List<CarRateDTO> rateList;

}
