package com.sabre.flight.pricing.control.baseprice;

import com.sabre.flight.pricing.entity.Flight;
import com.sabre.flight.pricing.entity.Money;

public interface FlightBasePriceService {
    Money getFlightBasePrice(Flight flight);
}
