package com.sabre.flight.shopping.web;

import com.sabre.flight.shopping.control.ItineraryOffersService;
import com.sabre.flight.shopping.entity.ItineraryOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItineraryOffersEndpoint {

    private final ItineraryOffersService itineraryOffersService;

    @Autowired
    public ItineraryOffersEndpoint(ItineraryOffersService itineraryOffersService) {
        this.itineraryOffersService = itineraryOffersService;
    }

    @GetMapping("/itineraryOffers")
    public List<ItineraryOffer> getItineraryOffers() {
        return itineraryOffersService.findPossibleItineraryOffers();
    }
}
