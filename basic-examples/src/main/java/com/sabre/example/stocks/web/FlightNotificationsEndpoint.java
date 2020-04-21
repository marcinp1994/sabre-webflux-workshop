package com.sabre.example.stocks.web;

import com.sabre.example.stocks.control.SabreStockService;
import com.sabre.example.stocks.entity.StockPrice;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class FlightNotificationsEndpoint {

    private final SabreStockService notificationService;

    public FlightNotificationsEndpoint(SabreStockService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping(value = "api/flight/notifications", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<StockPrice> getNotifications(@RequestParam(value = "count", required = false) Long count) {
        return notificationService.generateNotifications(Duration.ofMillis(200));
    }

}
