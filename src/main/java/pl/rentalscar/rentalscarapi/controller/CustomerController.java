package pl.rentalscar.rentalscarapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.rentalscar.rentalscarapi.service.CustomerService;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
}
