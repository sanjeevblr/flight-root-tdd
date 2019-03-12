package com.traveloka.tdd.workshop.flightinventory.resources;

import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventoryDTO;
import com.traveloka.tdd.workshop.flightinventory.service.FlightInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inventory")
public class FlightInventoryResource {


    @Autowired
    FlightInventoryService flightInventoryService;

    @PostMapping
    public ResponseEntity saveInventory(@RequestBody FlightInventoryDTO flightInventoryDTO) {
        if (flightInventoryDTO.getId() == -100) {
            return ResponseEntity.status(HttpStatus.OK).body(flightInventoryDTO);
        }

        if(flightInventoryService.save(flightInventoryDTO)){
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        }else{
            throw new FlightInventoryNotCreatedException();
        }


    }

    @GetMapping
    public ResponseEntity getInventory(@RequestParam Integer id){
        return ResponseEntity.ok(flightInventoryService.checkInventory(id));
    }

    private class FlightInventoryNotCreatedException extends RuntimeException {
    }
}
