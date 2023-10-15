package pl.rentalscar.rentalscarapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.rentalscar.rentalscarapi.service.RentalConditionService;

@RestController
@RequiredArgsConstructor
public class RentalConditionController {
    private final RentalConditionService rentalConditionService;
}
