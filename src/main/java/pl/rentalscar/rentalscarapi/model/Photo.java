package pl.rentalscar.rentalscarapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "src cannot be null")
    @Size(min = 12, max = 255, message = "src should be between 2 and 255 characters")
    private String src;

    @NotNull(message = "alt cannot be null")
    @Size(min = 1, max = 255, message = "alt should be between 2 and 255 characters")
    private String alt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @Enumerated(EnumType.STRING)
    private PhotoType photoType;


    public enum PhotoType {
        PROFILE_PHOTO, OTHER_PHOTO
    }
}
