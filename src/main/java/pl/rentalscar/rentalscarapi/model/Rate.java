package pl.rentalscar.rentalscarapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero(message = "Minimum days must be positive or zero")
    @Column(nullable = false)
    private Integer minDays;

    @PositiveOrZero(message = "Maximum days must be positive or zero")
    @Column(nullable = false)
    private Integer maxDays;

    @PositiveOrZero(message = "Daily rate must be positive or zero")
    @Column(nullable = false)
    private Double dailyRate;

    @ManyToOne
    @JoinColumn(name = "price_list_id")
    private PriceList priceList;
}
