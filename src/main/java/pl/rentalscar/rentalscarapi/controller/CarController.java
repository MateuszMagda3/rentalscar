package pl.rentalscar.rentalscarapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.rentalscar.rentalscarapi.dto.ReservationDateDTO;
import pl.rentalscar.rentalscarapi.dto.car.CarDetailsDTO;
import pl.rentalscar.rentalscarapi.dto.car.CarRateDTO;
import pl.rentalscar.rentalscarapi.dto.car.CarTileDTO;
import pl.rentalscar.rentalscarapi.dto.mapper.CarMapper;
import pl.rentalscar.rentalscarapi.dto.mapper.EquipmentMapper;
import pl.rentalscar.rentalscarapi.dto.mapper.RentalConditionMapper;
import pl.rentalscar.rentalscarapi.model.Car;
import pl.rentalscar.rentalscarapi.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CarController {


    private final CarService carService;
    private final CarMapper carMapper;
    private final EquipmentMapper equipmentMapper;
    private final RentalConditionMapper rentalConditionMapper;



    @GetMapping("/carsTiles")
    public List<CarTileDTO> getCarTileDTOLIst(){
        List<Car> carList = carService.getAllCars();
        return carList.stream()
                .map(carMapper::carToCarTileDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/carDetails")
    public CarDetailsDTO getCarDetailsDTO(@RequestParam(value = "id") Long id){
        return carMapper.carToCarDetailsDTO(carService.getById(id));
    }

    @PostMapping("/cars/free")
    public List<CarTileDTO> getFreeCars(@RequestBody ReservationDateDTO reservationDateDTO){
        List<Car> carList = carService.getFreeCarsInDate(reservationDateDTO.getPickupDate(),reservationDateDTO.getReturnDate());
        return carList.stream()
                .map(carMapper::carToCarTileDTO)
                .collect(Collectors.toList());
    }




    @GetMapping("/test")
    public int test(){
        return 1;
    }

}
