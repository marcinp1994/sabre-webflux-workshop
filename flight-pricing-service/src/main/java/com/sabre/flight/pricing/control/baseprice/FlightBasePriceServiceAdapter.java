package com.sabre.flight.pricing.control.baseprice;

import com.sabre.flight.pricing.control.util.DelayUtil;
import com.sabre.flight.pricing.entity.Flight;
import com.sabre.flight.pricing.entity.Money;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

@Service
public class FlightBasePriceServiceAdapter implements FlightBasePriceService {

    @Override
    public Money getFlightBasePrice(Flight flight) {
        DelayUtil.pauseThread(300);
        return new Money(BigDecimal.valueOf(Math.random() * 900 + 100), Currency.getInstance(Locale.US));
    }
}
