package ru.kaam.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.kaam.backend.dto.ConnectorDTO;
import ru.kaam.backend.service.ConnectorService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class ConnectorServiceImpl implements ConnectorService {

    private final ApplicationContext applicationContext;

    public void connect(ConnectorDTO connectorDTO) throws SQLException {
        Connection connection = DriverManager.getConnection(connectorDTO.url(), connectorDTO.userName(), connectorDTO.password());
        DefaultSingletonBeanRegistry registry = (DefaultSingletonBeanRegistry) applicationContext.getAutowireCapableBeanFactory();

        if (registry.getSingleton("connection") != null) {
            registry.destroySingleton("connection");
            registry.registerSingleton("connection", connection);
        } else {
            registry.registerSingleton("connection", connection);
        }
    }
}
