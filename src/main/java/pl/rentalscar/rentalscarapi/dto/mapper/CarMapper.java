package pl.rentalscar.rentalscarapi.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.rentalscar.rentalscarapi.dto.PhotoDTO;
import pl.rentalscar.rentalscarapi.dto.car.CarDetailsDTO;
import pl.rentalscar.rentalscarapi.dto.car.CarRateDTO;
import pl.rentalscar.rentalscarapi.dto.car.CarTileDTO;
import pl.rentalscar.rentalscarapi.model.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarMapper {

    private final PhotoMapper photoMapper;
    private final RateMaper rateMaper;

    public CarDetailsDTO carToCarDetailsDTO(Car car){
        CarDetailsDTO carDetailsDTO = new CarDetailsDTO();

        carDetailsDTO.setId(car.getId());
        carDetailsDTO.setMake(car.getMake());
        carDetailsDTO.setModel(car.getModel());
        carDetailsDTO.setDescription(car.getDescription());
        carDetailsDTO.setFuelType(String.valueOf(car.getFuelType()));
        carDetailsDTO.setNumberOfDoors(car.getNumberOfDoors());
        carDetailsDTO.setEngineSize(car.getEngineSize());
        carDetailsDTO.setTransmissionType(String.valueOf(car.getTransmissionType()));
        carDetailsDTO.setProductionYear(car.getProductionYear());

        List<String> equipmentList = car.getEquipment().stream()
                .map(Equipment::getName)
                .collect(Collectors.toList());
        carDetailsDTO.setEquipmentList(equipmentList);

        List<String> rentalConditionList = car.getRentalConditions().stream()
                .map(RentalCondition::getDescription)
                .collect(Collectors.toList());
        carDetailsDTO.setRentalConditionList(rentalConditionList);

        List<PhotoDTO> photoDTOList = car.getPhotos().stream()
                .map(photoMapper::photoToPhotoDTO)
                .collect(Collectors.toList());
        carDetailsDTO.setPhotoList(photoDTOList);

        List<CarRateDTO> carRateDTOList = car.getPriceList().getRates().stream()
                .map(rateMaper::RateToRateDTO)
                .collect(Collectors.toList());
        carDetailsDTO.setRateList(carRateDTOList);

        return carDetailsDTO;
    }

    public CarTileDTO carToCarTileDTO (Car car){
        CarTileDTO carTileDTO = new CarTileDTO();

        carTileDTO.setId(car.getId());
        carTileDTO.setMake(car.getMake());
        carTileDTO.setModel(car.getModel());

        Optional<Double> minRate = car.getPriceList().getRates().stream()
                .min(Comparator.comparing(Rate::getDailyRate))
                .map(Rate::getDailyRate);
        carTileDTO.setMinPrice(minRate.get());

        Optional<Photo> profilePhoto = car.getPhotos().stream()
                .filter(photo -> Photo.PhotoType.PROFILE_PHOTO.equals(photo.getPhotoType()))
                .findFirst();

        if (profilePhoto.isPresent()) {
            Photo foundPhoto = profilePhoto.get();
            carTileDTO.setPhoto(foundPhoto.getSrc());
        } else {
            // Obiekt Photo z PhotoType.PROFILE_PHOTO nie został znaleziony na liście
        }

        return carTileDTO;
    }
}
