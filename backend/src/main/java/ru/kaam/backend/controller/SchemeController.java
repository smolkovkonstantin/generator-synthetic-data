package ru.kaam.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheme")
public class SchemeController {

    @GetMapping("/get")
    public ResponseEntity<?> getScheme() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/table/{id}")
    public ResponseEntity<?> getTable(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
