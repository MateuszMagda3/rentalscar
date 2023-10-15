package pl.rentalscar.rentalscarapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Nazwa elementu wyposażenia

    @ManyToMany(mappedBy = "equipment")
    private Set<Car> cars; // Lista samochodów, które mają ten element wyposażenia
}
