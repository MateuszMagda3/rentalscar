package pl.rentalscar.rentalscarapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rentalscar.rentalscarapi.model.*;
import pl.rentalscar.rentalscarapi.repository.CarRepository;
import pl.rentalscar.rentalscarapi.repository.EquipmentRepository;
import pl.rentalscar.rentalscarapi.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final EquipmentRepository equipmentRepository;
    private final ReservationRepository reservationRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car getById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Equipment> getEquipmentListById(Long id){
        Car car = getById(id);
        return car.getEquipment().stream().toList();
    }

    public List<RentalCondition> getRentalConditionDTOListById(Long id){
        Car car = getById(id);
        return car.getRentalConditions().stream().toList();
    }

    public List<Car> getFreeCarsInDate(LocalDate pickupDate, LocalDate returnDate) {
        List<Car> carList = carRepository.findAll();

        List<Reservation> activeReservations = new ArrayList<>();
        activeReservations.addAll(reservationRepository.findReservationByStatus(ReservationStatus.CONFIRMED));
        activeReservations.addAll(reservationRepository.findReservationByStatus(ReservationStatus.IN_PROGRESS));

        List<Car> carsToRemove = activeReservations.stream()
                .filter(reservation -> {
                    LocalDate startDate = reservation.getStartDate();
                    LocalDate endDate = reservation.getEndDate();
                    return (startDate.isEqual(pickupDate)
                            || (startDate.isBefore(pickupDate) && !endDate.isBefore(pickupDate))
                            || (startDate.isAfter(pickupDate) && !startDate.isAfter(returnDate))
                            || (startDate.isBefore(pickupDate) && endDate.isAfter(returnDate)));
                })
                .map(Reservation::getCar)
                .toList();
        carList.removeAll(carsToRemove);
        return carList;
    }
}
