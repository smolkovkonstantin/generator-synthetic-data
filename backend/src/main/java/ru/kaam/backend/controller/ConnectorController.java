package ru.kaam.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectorController {

    @PostMapping("/connect?{connection_url}")
    public ResponseEntity<?> connect(@PathVariable("connection_url") String url){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
