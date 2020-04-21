package com.sabre.example.stocks.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StockPrice {
    private final LocalDateTime time;
    private final BigDecimal price;

    public StockPrice(BigDecimal price) {
        this.time = LocalDateTime.now();
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
