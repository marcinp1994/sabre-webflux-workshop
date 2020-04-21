package com.sabre.flight.shopping.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private final Long flightNumber;
    private final LocalDateTime departureTime;
    private final String origin;
    private final String destination;

    @JsonCreator
    public Flight(@JsonProperty("flightNumber") Long flightNumber,
                  @JsonProperty("departureTime") LocalDateTime departureTime,
                  @JsonProperty("origin") String origin,
                  @JsonProperty("destination") String destination) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.origin = origin;
        this.destination = destination;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNumber, flight.flightNumber) &&
                Objects.equals(departureTime, flight.departureTime) &&
                Objects.equals(origin, flight.origin) &&
                Objects.equals(destination, flight.destination);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flightNumber, departureTime, origin, destination);
    }
}
