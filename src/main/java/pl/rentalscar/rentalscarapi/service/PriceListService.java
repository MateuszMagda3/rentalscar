package pl.rentalscar.rentalscarapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rentalscar.rentalscarapi.repository.PriceListRepository;

@Service
@RequiredArgsConstructor
public class PriceListService {

    private final PriceListRepository priceListRepository;

}
