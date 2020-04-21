package com.sabre.example.stocks.control;

import com.sabre.example.stocks.entity.StockPrice;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@Component
public class StockPriceGenerator {

    private final Flux<StockPrice> stockPriceStream;

    public StockPriceGenerator() {
        this.stockPriceStream = Flux.generate(() -> new StockPrice(BigDecimal.valueOf(25)), (previousPrice, sink) -> {
            StockPrice newStockPrice = new StockPrice(nextPrice(previousPrice.getPrice()));
            sink.next(newStockPrice);
            return newStockPrice;
        });
    }

    private BigDecimal nextPrice(BigDecimal price) {
        double random = Math.random();
        if (random < 0.45) {
            return price.add(BigDecimal.valueOf(Math.random()));
        } else if (random < 0.85) {
            return price.subtract(BigDecimal.valueOf(Math.random()));
        }
        return price;
    }

    public Flux<StockPrice> streamFlightNotifications() {
        return stockPriceStream;
    }
}
