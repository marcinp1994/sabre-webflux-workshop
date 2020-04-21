package com.sabre.flight.pricing.web;

import com.sabre.flight.pricing.control.FlightPricingService;
import com.sabre.flight.pricing.entity.Flight;
import com.sabre.flight.pricing.entity.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightPricingServiceEndpoint {
    private final FlightPricingService flightPricingService;

    @Autowired
    public FlightPricingServiceEndpoint(FlightPricingService flightPricingService) {
        this.flightPricingService = flightPricingService;
    }

    @PostMapping(value = "/getFlightPrice", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Money getFlightOffer(@RequestBody Flight flight) {
        return flightPricingService.getFlightOffer(flight);
    }
}
