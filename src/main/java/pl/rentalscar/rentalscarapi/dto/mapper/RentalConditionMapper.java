package pl.rentalscar.rentalscarapi.dto.mapper;

import org.springframework.stereotype.Component;
import pl.rentalscar.rentalscarapi.dto.RentalConditionDTO;
import pl.rentalscar.rentalscarapi.model.RentalCondition;

@Component
public class RentalConditionMapper {

    public RentalConditionDTO toDTO(RentalCondition rentalCondition){
        RentalConditionDTO rentalConditionDTO = new RentalConditionDTO();
        rentalConditionDTO.setId(rentalCondition.getId());
        rentalConditionDTO.setDescription(rentalCondition.getDescription());
        return rentalConditionDTO;
    }
}
