package com.sabre.example.stocks.control;

import com.sabre.example.stocks.entity.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class SabreStockService {

    private final StockPriceGenerator stockPriceGenerator;

    @Autowired
    public SabreStockService(StockPriceGenerator stockPriceGenerator) {
        this.stockPriceGenerator = stockPriceGenerator;
    }

    public Flux<StockPrice> generateNotifications(Duration interval) {
        return null; //TODO
    }
}
