package pl.rentalscar.rentalscarapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.rentalscar.rentalscarapi.service.EquipmentService;

@RestController
@RequiredArgsConstructor
public class EquipmentController {
    private final EquipmentService equipmentService;
}
