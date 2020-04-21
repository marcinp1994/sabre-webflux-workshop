package com.sabre.flight.pricing.control.discount;

import com.sabre.flight.pricing.control.util.DelayUtil;
import com.sabre.flight.pricing.entity.Flight;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class FlightDiscountServiceAdapter implements FlightDiscountService {
    @Override
    public BigDecimal getDiscountPercentage(Flight flight) {
        DelayUtil.pauseThread(200);
        if (flight.getOrigin().equals("KRK")) {
            return BigDecimal.TEN;
        }
        if (flight.getDepartureTime().isBefore(LocalDateTime.now().plusDays(10))) {
            return BigDecimal.valueOf(5);
        }

        return BigDecimal.ZERO;
    }
}
