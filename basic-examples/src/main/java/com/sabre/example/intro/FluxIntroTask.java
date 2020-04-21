package com.sabre.example.intro;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxIntroTask {

    public static void main(String[] argv) throws InterruptedException {
        fooBar().log("task1").subscribe();
        fromList(Arrays.asList("Flux", "Mono", "Spring")).log("task2").subscribe();
        emittingFlux();
        zipNames(Flux.just("Jan", "Piotr", "Pawel"), Flux.just("Kowalski", "Wisniewski", "Nowak"));
        printShoppingBasketProducts(Flux.just(new ShoppingBasket("apple", "orange"), new ShoppingBasket("bread", "cucumber")));
        Thread.sleep(5000);
    }

    //flux creation
    //return flux with "foo" and "bar" values
    private static Flux<String> fooBar() {
        return null;//TODO
    }

    //return flux containing length of each emitted word
    private static Flux<Integer> fromList(List<String> words) {
        return null;//TODO
    }

    //create flux that emits 10 values, each with 500ms interval
    private static void emittingFlux() {
        //TODO
    }

    // given 2 streams - first emits names, second surnames
    // zip and print those 2 streams as 'name - surname'
    private static void zipNames(Flux<String> name, Flux<String> surname) {
        //TODO
    }

    //given flux of shopping baskets
    //print all products of each shopping basket
    private static void printShoppingBasketProducts(Flux<ShoppingBasket> shoppingBasketFlux) {
        //TODO
    }


}
