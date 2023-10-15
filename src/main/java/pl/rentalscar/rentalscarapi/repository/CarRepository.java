package pl.rentalscar.rentalscarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rentalscar.rentalscarapi.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
