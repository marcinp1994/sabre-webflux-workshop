package com.sabre.flight.pricing.control.discount;

import com.sabre.flight.pricing.entity.Flight;

import java.math.BigDecimal;

public interface FlightDiscountService {
    BigDecimal getDiscountPercentage(Flight flight);
}
