package pl.rentalscar.rentalscarapi.dto.mapper;

import org.springframework.stereotype.Component;
import pl.rentalscar.rentalscarapi.dto.EquipmentDTO;
import pl.rentalscar.rentalscarapi.model.Equipment;

@Component
public class EquipmentMapper {

    public EquipmentDTO toDTO(Equipment equipment){
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        equipmentDTO.setId(equipment.getId());
        equipmentDTO.setName(equipment.getName());
        return equipmentDTO;
    }
}
