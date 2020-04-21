package com.sabre.flight.shopping.control;

import com.sabre.flight.shopping.entity.Flight;

public interface FlightDetailsRepository {
    Flight getFlightDetails(Long flightId);
}
