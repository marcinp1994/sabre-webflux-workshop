package com.sabre.flight.shopping.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    private final List<Long> flightIds;

    @JsonCreator
    public Connection(@JsonProperty("flightIds") List<Long> flightIds) {
        this.flightIds = new ArrayList<>(flightIds);
    }

    public List<Long> getFlightIds() {
        return new ArrayList<>(flightIds);
    }
}
