package com.sabre.example.intro;

import reactor.core.publisher.Flux;

public class ShoppingBasket {
    private String[] products;

    public ShoppingBasket(String... products) {
        this.products = products;
    }

    public Flux<String> getProducts() {
        return Flux.just(products);
    }
}
