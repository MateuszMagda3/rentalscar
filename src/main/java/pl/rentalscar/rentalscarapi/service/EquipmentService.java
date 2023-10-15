package pl.rentalscar.rentalscarapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rentalscar.rentalscarapi.model.Equipment;
import pl.rentalscar.rentalscarapi.repository.EquipmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

}
