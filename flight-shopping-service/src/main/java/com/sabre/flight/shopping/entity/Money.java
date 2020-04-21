package com.sabre.flight.shopping.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {
    private final BigDecimal price;
    private final Currency currency;

    @JsonCreator
    public Money(@JsonProperty("price") BigDecimal price,
                 @JsonProperty("currency") Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }
}
