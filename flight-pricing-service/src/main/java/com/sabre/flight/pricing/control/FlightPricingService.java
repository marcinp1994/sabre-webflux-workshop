package com.sabre.flight.pricing.control;

import com.sabre.flight.pricing.control.baseprice.FlightBasePriceService;
import com.sabre.flight.pricing.control.discount.FlightDiscountService;
import com.sabre.flight.pricing.entity.Flight;
import com.sabre.flight.pricing.entity.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class FlightPricingService {

    private final FlightBasePriceService flightBasePriceService;
    private final FlightDiscountService flightDiscountService;

    @Autowired
    public FlightPricingService(FlightBasePriceService flightBasePriceService, FlightDiscountService flightDiscountService) {
        this.flightBasePriceService = flightBasePriceService;
        this.flightDiscountService = flightDiscountService;
    }

    public Money getFlightOffer(Flight flight) {
        Money baseFlightPrice = flightBasePriceService.getFlightBasePrice(flight);
        BigDecimal discountPercentage = flightDiscountService.getDiscountPercentage(flight);
        return applyDiscount(baseFlightPrice, discountPercentage);
    }

    private Money applyDiscount(Money baseFlightPrice, BigDecimal discountPercentage) {
        BigDecimal basePrice = baseFlightPrice.getPrice();
        BigDecimal discounted = BigDecimal.valueOf(100).subtract(discountPercentage).multiply(basePrice).divide(BigDecimal.valueOf(100), BigDecimal.ROUND_HALF_DOWN);
        return new Money(discounted, baseFlightPrice.getCurrency());
    }
}
