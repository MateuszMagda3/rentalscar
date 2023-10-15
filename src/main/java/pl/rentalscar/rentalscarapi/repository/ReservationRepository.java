package pl.rentalscar.rentalscarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rentalscar.rentalscarapi.model.Reservation;
import pl.rentalscar.rentalscarapi.model.ReservationStatus;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationByStatus(ReservationStatus status);

    List<Reservation> findReservationByStatusIn(List<String> activeStatuses);
}
