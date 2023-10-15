package pl.rentalscar.rentalscarapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.rentalscar.rentalscarapi.dto.reservation.ReservationDTO;
import pl.rentalscar.rentalscarapi.dto.mapper.ReservationMapper;
import pl.rentalscar.rentalscarapi.model.Reservation;
import pl.rentalscar.rentalscarapi.service.ReservationService;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;


    @PostMapping("/reservations/add")
    public ResponseEntity<ReservationDTO> addReservation(@RequestBody ReservationDTO reservationAddDTO) {
        // Zamiana DTO na encję
        Reservation reservation = reservationMapper.toEntity(reservationAddDTO);

        // Tworzenie rezerwacji za pomocą serwisu
        Reservation createdReservation = reservationService.createReservation(reservation);

        // Zwracanie utworzonej rezerwacji
        return new ResponseEntity<>(reservationMapper.toDTO(createdReservation), HttpStatus.CREATED);

    }
}
