package com.sabre.possible.connections.control.reactive;

import com.sabre.possible.connections.control.calculations.ConnectionCalculatorFactory;
import com.sabre.possible.connections.control.calculations.ConnectionsCalculator;
import com.sabre.possible.connections.entity.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class PossibleConnectionsProviderReactiveService {
    private final ConnectionCalculatorFactory connectionCalculatorFactory;

    @Autowired
    public PossibleConnectionsProviderReactiveService(ConnectionCalculatorFactory connectionCalculatorFactory) {
        this.connectionCalculatorFactory = connectionCalculatorFactory;
    }

    public Flux<Connection> getPossibleConnections() {
        ConnectionsCalculator connectionsCalculator = connectionCalculatorFactory.get();
        Flux<Connection> connectionFlux = Flux.from(subscriber -> {
            //implement me //TODO
        });
        return connectionFlux.subscribeOn(Schedulers.newSingle("Calculations scheduler"));
    }
}
