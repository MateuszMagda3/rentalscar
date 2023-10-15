package pl.rentalscar.rentalscarapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rentalscar.rentalscarapi.model.Customer;
import pl.rentalscar.rentalscarapi.model.Reservation;
import pl.rentalscar.rentalscarapi.repository.CustomerRepository;
import pl.rentalscar.rentalscarapi.repository.ReservationRepository;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    public Reservation createReservation(Reservation reservation) {
        if(reservation.getCustomer().getId() == null)
            customerRepository.save(reservation.getCustomer());
        LocalDateTime localDateTime = LocalDateTime.now();
        reservation.setDateOfBooking(localDateTime);
        reservationRepository.save(reservation);
        return reservation;
    }
}
