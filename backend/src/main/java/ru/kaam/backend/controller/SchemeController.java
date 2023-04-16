package ru.kaam.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kaam.backend.model.Scheme;
import ru.kaam.backend.model.Table;
import ru.kaam.backend.service.SchemeService;

import java.sql.SQLException;

/**
 * End points для работы со схемой БД.
 */
@RestController
@RequestMapping("/scheme")
@RequiredArgsConstructor
public class SchemeController {

    private final SchemeService schemeService;

    @GetMapping()
    public ResponseEntity<Scheme> getScheme() throws SQLException {
        return ResponseEntity.ok(schemeService.getScheme());
    }

    @GetMapping("/table/{table_name}")
    public ResponseEntity<Table> getTable(@PathVariable("table_name") String tableName) throws SQLException {
        return ResponseEntity.ok(schemeService.getTable(tableName));
    }
}
