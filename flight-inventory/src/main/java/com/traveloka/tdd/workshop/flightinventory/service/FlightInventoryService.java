package com.traveloka.tdd.workshop.flightinventory.service;

import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventory;
import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventoryDTO;
import com.traveloka.tdd.workshop.flightinventory.repository.FlightInventoryRepsitory;
import com.traveloka.tdd.workshop.flightinventory.transformer.FlightInventoryTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightInventoryService {

    @Autowired
    FlightInventoryRepsitory flightInventoryRepsitory;

    @Autowired
    FlightInventoryTransformer flightInventoryTransformer;

    public boolean save(FlightInventoryDTO flightInventoryDTO) {

        if (flightInventoryDTO != null && !flightInventoryDTO.isValid()) {
            return false;
        }

        FlightInventory flightInventory = flightInventoryTransformer
                .transform(flightInventoryDTO);
        FlightInventory saved = flightInventoryRepsitory.save(flightInventory);
        return saved != null;
    }


}
