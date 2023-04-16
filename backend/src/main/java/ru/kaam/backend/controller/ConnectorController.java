package ru.kaam.backend.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kaam.backend.dto.ConnectorDTO;
import ru.kaam.backend.service.ConnectorService;

/**
 * End points для подключения к базе данных.
 */
@RestController
@RequiredArgsConstructor
public class ConnectorController {

    private final ConnectorService connectorService;

    @ApiResponse(
            responseCode = "200",
            description = "Соединение с БД установлено"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Соединение с БД не установлено"
    )
    @PostMapping("/connect")
    public ResponseEntity<?> setConnector(@RequestBody ConnectorDTO connectorDTO) {
        try {
            connectorService.connect(connectorDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
