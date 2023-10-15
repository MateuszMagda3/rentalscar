package pl.rentalscar.rentalscarapi.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.rentalscar.rentalscarapi.dto.reservation.ReservationDTO;
import pl.rentalscar.rentalscarapi.model.Customer;
import pl.rentalscar.rentalscarapi.model.Reservation;
import pl.rentalscar.rentalscarapi.model.ReservationStatus;
import pl.rentalscar.rentalscarapi.repository.CustomerRepository;
import pl.rentalscar.rentalscarapi.service.CarService;

@Component
@RequiredArgsConstructor
public class ReservationMapper {

    private final CarService carService;
    private final CustomerRepository customerRepository;

    public ReservationDTO toDTO(Reservation reservation) {
        ReservationDTO reservationAddDTO = new ReservationDTO();

        reservationAddDTO.setCarId(reservation.getCar().getId());
        reservationAddDTO.setFirstName(reservation.getCustomer().getFirstName());
        reservationAddDTO.setLastName(reservation.getCustomer().getLastName());
        reservationAddDTO.setPhoneNumber(reservation.getCustomer().getPhoneNumber());
        reservationAddDTO.setEmail(reservation.getCustomer().getEmail());
        reservationAddDTO.setStartDate(reservation.getStartDate());
        reservationAddDTO.setEndDate(reservation.getEndDate());

        return reservationAddDTO;
    }
    public Reservation toEntity(ReservationDTO reservationAddDTO){
        Reservation reservation = new Reservation();

        Customer customer = customerRepository.findCustomerByFirstNameAndLastNameAndEmailAndPhoneNumber(reservationAddDTO.getFirstName(), reservationAddDTO.getLastName(), reservationAddDTO.getEmail(), reservationAddDTO.getPhoneNumber());
        if(customer == null){
            customer = new Customer();

            customer.setEmail(reservationAddDTO.getEmail());
            customer.setPhoneNumber(reservationAddDTO.getPhoneNumber());
            customer.setFirstName(reservationAddDTO.getFirstName());
            customer.setLastName(reservationAddDTO.getLastName());
        }

        reservation.setCar(carService.getById(reservationAddDTO.getCarId()));
        reservation.setStartDate(reservationAddDTO.getStartDate());
        reservation.setEndDate(reservationAddDTO.getEndDate());
        reservation.setCustomer(customer);
        reservation.setStatus(ReservationStatus.SUBMITTED);

        return reservation;
    }

}
