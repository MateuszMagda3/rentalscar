package pl.rentalscar.rentalscarapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.rentalscar.rentalscarapi.dto.ReservationDateDTO;
import pl.rentalscar.rentalscarapi.dto.message.MessageDTO;

@RestController
@RequiredArgsConstructor
public class MessageController {

        @PostMapping("/sendMessage")
        public Integer getFreeCars(@RequestBody MessageDTO messageDTO){

            return 1;
    }
}
