package pl.rentalscar.rentalscarapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rentalscar.rentalscarapi.repository.RentalConditionRepository;

@Service
@RequiredArgsConstructor
public class RentalConditionService {

    private final RentalConditionRepository rentalConditionRepository;
}
