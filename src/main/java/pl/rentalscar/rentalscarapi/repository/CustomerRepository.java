package pl.rentalscar.rentalscarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rentalscar.rentalscarapi.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByFirstNameAndLastNameAndEmailAndPhoneNumber(String firstName, String lastName, String email, String phoneNumber);
}
