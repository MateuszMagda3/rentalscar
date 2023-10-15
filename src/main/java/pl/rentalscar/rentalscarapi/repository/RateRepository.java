package pl.rentalscar.rentalscarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rentalscar.rentalscarapi.model.Rate;

public interface RateRepository extends JpaRepository<Rate, Long> {
}
