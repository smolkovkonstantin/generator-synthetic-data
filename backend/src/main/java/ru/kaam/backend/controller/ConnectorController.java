package ru.kaam.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kaam.backend.dto.ConnectorDTO;

import javax.sql.DataSource;

@RestController
@RequiredArgsConstructor
public class ConnectorController {

    private final DataSource dataSource;
    private final ConfigurableApplicationContext context;
    @PostMapping("/connect")
    public void connect(@RequestBody ConnectorDTO connectorDTO){
        // Set the URL, username, and password dynamically at runtime
        ((DriverManagerDataSource) dataSource).setUrl(connectorDTO.url());
        ((DriverManagerDataSource) dataSource).setUsername(connectorDTO.userName());
        ((DriverManagerDataSource) dataSource).setPassword(connectorDTO.password());

        context.refresh();
    }

//    @PostMapping("/1")
//    public ResponseEntity<ConnectorDTO> a(@RequestBody ConnectorDTO connectorDTO){
//        return ResponseEntity.ok(connectorDTO);
//    }
}
