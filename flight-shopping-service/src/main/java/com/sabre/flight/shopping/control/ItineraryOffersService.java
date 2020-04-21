package com.sabre.flight.shopping.control;

import com.sabre.flight.shopping.control.connections.PossibleConnectionsService;
import com.sabre.flight.shopping.control.flightdetails.FlightDetailsService;
import com.sabre.flight.shopping.control.pricing.FlightPricingService;
import com.sabre.flight.shopping.entity.Connection;
import com.sabre.flight.shopping.entity.Flight;
import com.sabre.flight.shopping.entity.ItineraryOffer;
import com.sabre.flight.shopping.entity.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.toList;

@Service
public class ItineraryOffersService {

    private final FlightPricingService flightPricingService;
    private final FlightDetailsService flightDetailsService;
    private final PossibleConnectionsService possibleConnectionsService;

    @Autowired
    public ItineraryOffersService(FlightPricingService flightPricingService,
                                  FlightDetailsService flightDetailsService,
                                  PossibleConnectionsService possibleConnectionsService) {
        this.flightPricingService = flightPricingService;
        this.flightDetailsService = flightDetailsService;
        this.possibleConnectionsService = possibleConnectionsService;
    }

    public List<ItineraryOffer> findPossibleItineraryOffers() {
        List<Connection> possibleConnections = possibleConnectionsService.getPossibleConnections();
        return possibleConnections.stream()
                .map(this::createItineraryOffer)
                .collect(toList());
    }

    private ItineraryOffer createItineraryOffer(Connection connection) {
        List<Flight> flights = connection.getFlightIds().stream()
                .map(flightDetailsService::getFlightDetails)
                .collect(toList());
        List<Money> flightPrices = flights.stream()
                .map(flightPricingService::getFlightPrice)
                .collect(toList());
        BigDecimal totalPrice = flightPrices.stream()
                .map(Money::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Currency currency = flightPrices.stream().findFirst()
                .map(Money::getCurrency)
                .orElse(Currency.getInstance(Locale.US));
        return new ItineraryOffer(flights, new Money(totalPrice, currency));
    }

}
