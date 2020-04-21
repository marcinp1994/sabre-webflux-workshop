package com.sabre.possible.connections.control.calculations;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class ConnectionCalculatorFactory implements Supplier<ConnectionsCalculator> {
    @Override
    public ConnectionsCalculator get() {
        return new SingleThreadConnectionsCalculator();
    }
}
