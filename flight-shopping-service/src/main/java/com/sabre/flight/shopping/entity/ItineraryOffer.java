package com.sabre.flight.shopping.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ItineraryOffer {
    private final List<Flight> flights;
    private final Money price;

    @JsonCreator
    public ItineraryOffer(
            @JsonProperty("flights") List<Flight> flights,
            @JsonProperty("price") Money price) {
        this.flights = flights;
        this.price = price;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public Money getPrice() {
        return price;
    }
}
