package pl.rentalscar.rentalscarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rentalscar.rentalscarapi.model.RentalCondition;

public interface RentalConditionRepository extends JpaRepository<RentalCondition, Long> {
}
