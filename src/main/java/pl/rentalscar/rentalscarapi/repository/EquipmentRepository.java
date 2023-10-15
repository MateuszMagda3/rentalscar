package pl.rentalscar.rentalscarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rentalscar.rentalscarapi.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
