package pl.rentalscar.rentalscarapi.dto.mapper;

import org.springframework.stereotype.Component;
import pl.rentalscar.rentalscarapi.dto.car.CarRateDTO;
import pl.rentalscar.rentalscarapi.model.Rate;

@Component
public class RateMaper {
    public CarRateDTO RateToRateDTO (Rate rate){
        CarRateDTO carRateDTO = new CarRateDTO();

        carRateDTO.setMinDays(rate.getMinDays());
        carRateDTO.setMaxDays(rate.getMaxDays());
        carRateDTO.setDailyRate(rate.getDailyRate());

        return carRateDTO;
    }
}
