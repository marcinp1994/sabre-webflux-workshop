package com.sabre.flight.shopping.control;

import com.google.common.collect.ImmutableMap;
import com.sabre.flight.shopping.entity.Flight;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Map;

@Repository
public class InMemoryFlightsRepository implements FlightDetailsRepository {

    private final Map<Long, Flight> ALL_FLIGHTS = ImmutableMap.<Long, Flight>builder()
            .put(0L, new Flight(1001L, LocalDateTime.now().plusDays(4), "KRK", "LAX"))
            .put(1L, new Flight(1010L, LocalDateTime.now().plusDays(5), "LON", "BCN"))
            .put(2L, new Flight(1200L, LocalDateTime.now().plusDays(6), "LAX", "BOS"))
            .put(3L, new Flight(1205L, LocalDateTime.now().plusDays(7), "BOS", "LON"))
            .put(4L, new Flight(1500L, LocalDateTime.now().plusDays(4), "KRK", "LAX"))
            .put(5L, new Flight(1522L, LocalDateTime.now().plusDays(3), "BOS", "WWA"))
            .put(6L, new Flight(1523L, LocalDateTime.now().plusDays(5), "CHO", "LON"))
            .put(7L, new Flight(1580L, LocalDateTime.now().plusDays(8), "BOS", "DDW"))
            .put(8L, new Flight(1614L, LocalDateTime.now().plusDays(12), "KRK", "WWA"))
            .put(9L, new Flight(1638L, LocalDateTime.now().plusDays(15), "BCN", "LON"))
            .put(10L, new Flight(1800L, LocalDateTime.now().plusDays(11), "LAX", "WWA"))
            .put(11L, new Flight(1801L, LocalDateTime.now().plusDays(3), "KRK", "CHO"))
            .put(12L, new Flight(1804L, LocalDateTime.now().plusDays(8), "BCN", "LON"))
            .put(13L, new Flight(1928L, LocalDateTime.now().plusDays(3), "DDW", "WWA"))
            .put(14L, new Flight(2001L, LocalDateTime.now().plusDays(6), "LAX", "CHO"))
            .put(15L, new Flight(2150L, LocalDateTime.now().plusDays(7), "BCN", "DDW"))
            .build();


    @Override
    public Flight getFlightDetails(Long flightId) {
        return ALL_FLIGHTS.get(flightId);
    }
}
