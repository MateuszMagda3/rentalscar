package pl.rentalscar.rentalscarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rentalscar.rentalscarapi.model.PriceList;

public interface PriceListRepository extends JpaRepository<PriceList, Long> {
}
