package ru.kaam.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kaam.backend.dto.ConnectorDTO;
import ru.kaam.backend.model.PostgreSQLComponent;
import ru.kaam.backend.service.ConnectorService;

@Service
@RequiredArgsConstructor
public class ConnectorServiceImpl implements ConnectorService {

    private final PostgreSQLComponent postgreSQLComponent;

    @Override
    public void createConnect(ConnectorDTO connectorDTO) {
        postgreSQLComponent.init(connectorDTO.url(), connectorDTO.userName(), connectorDTO.password());
    }
}
