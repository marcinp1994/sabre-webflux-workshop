package com.sabre.possible.connections.control.calculations;

import com.sabre.possible.connections.entity.Connection;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class SingleThreadConnectionsCalculator implements ConnectionsCalculator {
    private long lastGeneratedTime;
    private int connectionsToBeGenerated;
    private List<Long> possibleFlightIds = allPossibleFlightIds();

    public SingleThreadConnectionsCalculator() {
        connectionsToBeGenerated = (int) (Math.random() * 12) + 2;
    }

    private long simulateGenerationTime() {
        return (long) (Math.random() * 200 + 100);
    }

    public Connection getNextConnection() {
        if (connectionsToBeGenerated <= 0) {
            throw new IllegalStateException("Unable to generate next connection");
        }

        long nextGenerationTime = simulateGenerationTime();
        while (lastGeneratedTime + nextGenerationTime > System.currentTimeMillis()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lastGeneratedTime = System.currentTimeMillis();
        --connectionsToBeGenerated;
        return generateConnection();
    }

    private Connection generateConnection() {
        List<Long> flightIds = IntStream.range(0, (int) (1 + Math.random() * 3))
                .asLongStream()
                .map(number -> generateFlightId())
                .boxed()
                .collect(toList());
        possibleFlightIds = allPossibleFlightIds();
        return new Connection(flightIds);
    }

    private long generateFlightId() {
        Collections.shuffle(possibleFlightIds);
        Long flightId = possibleFlightIds.get(0);
        possibleFlightIds.remove(0);
        return flightId;
    }

    private List<Long> allPossibleFlightIds() {
        return IntStream.range(0, 15).asLongStream().boxed().collect(toList());
    }

    public boolean nextConnectionExists() {
        return connectionsToBeGenerated > 0;
    }
}
