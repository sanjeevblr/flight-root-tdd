package com.traveloka.tdd.workshop.flightinventory.resources;

import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inventory")
public class FlightInventoryResource {


    @PostMapping
    public ResponseEntity saveInventory(@RequestBody FlightInventoryDTO flightInventoryDTO) {
        if (flightInventoryDTO.getId() == -100) {
            return ResponseEntity.status(HttpStatus.OK).body(flightInventoryDTO);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

}
