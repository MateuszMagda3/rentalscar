package pl.rentalscar.rentalscarapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rentalscar.rentalscarapi.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
}