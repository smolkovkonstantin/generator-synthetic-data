package ru.kaam.backend.service;

import ru.kaam.backend.dto.ConnectorDTO;

import java.sql.SQLException;

public interface ConnectorService {
    void connect(ConnectorDTO connectorDTO) throws SQLException;
}
