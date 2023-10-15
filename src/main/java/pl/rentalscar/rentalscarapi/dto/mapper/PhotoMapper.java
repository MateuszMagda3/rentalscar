package pl.rentalscar.rentalscarapi.dto.mapper;

import org.springframework.stereotype.Component;
import pl.rentalscar.rentalscarapi.dto.PhotoDTO;
import pl.rentalscar.rentalscarapi.model.Photo;

@Component
public class PhotoMapper {
    public PhotoDTO photoToPhotoDTO(Photo photo){
        PhotoDTO photoDTO = new PhotoDTO();

        photoDTO.setSrc(photo.getSrc());
        photoDTO.setAlt(photo.getAlt());
        photoDTO.setCarId(photo.getCar().getId());
        photoDTO.setPhotoType(String.valueOf(photo.getPhotoType()));

        return photoDTO;
    }
}
