package pl.rentalscar.rentalscarapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhotoDTO {
    private String src;
    private String alt;
    private Long carId;
    private String photoType;
}
