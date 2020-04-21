package com.sabre.flight.shopping.web;

import com.google.common.base.Preconditions;
import com.sabre.flight.shopping.control.FlightDetailsRepository;
import com.sabre.flight.shopping.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightDetailsEndpoint {

    private final FlightDetailsRepository flightDetailsRepository;

    @Autowired
    public FlightDetailsEndpoint(FlightDetailsRepository flightDetailsRepository) {
        this.flightDetailsRepository = flightDetailsRepository;
    }

    @GetMapping("/flight/{id}")
    public Flight getFlightDetails(@PathVariable("id") Long flightId) {
        Preconditions.checkArgument(flightId < 15 && flightId >= 0, "Only 0-14 flight ids allowed");
        return flightDetailsRepository.getFlightDetails(flightId);
    }
}
