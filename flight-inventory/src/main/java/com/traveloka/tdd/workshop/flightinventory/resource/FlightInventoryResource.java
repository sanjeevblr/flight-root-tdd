package com.traveloka.tdd.workshop.flightinventory.resource;

import com.traveloka.tdd.workshop.flightinventory.model.FlightInventory;
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
    ResponseEntity createFlightInventory(@RequestBody FlightInventory flightInventory){

        if(flightInventory.getId() == -100){
            if(flightInventory.isComplete()){
                return ResponseEntity.ok("parsed");
            }
        }

        boolean saved = flightInventoryService.save(flightInventory);
        if(saved){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            throw new FlightInventoryNotCreatedException();
        }


    }

    @GetMapping
    ResponseEntity isInventoryExists(@RequestParam Integer id){
        FlightInventory flightInventory = flightInventoryService.find(id);
        return ResponseEntity.ok(flightInventory != null);
    }

    private class FlightInventoryNotCreatedException extends RuntimeException {
    }
}
