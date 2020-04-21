package com.sabre.possible.connections.control.calculations;

import com.sabre.possible.connections.entity.Connection;

public interface ConnectionsCalculator {
    boolean nextConnectionExists();

    Connection getNextConnection();
}
