package ru.kaam.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kaam.backend.dto.GeneratorDTO;
import ru.kaam.backend.service.GeneratorService;

@RestController
@RequestMapping("/generate")
@RequiredArgsConstructor
public class GeneratorController {

    private final GeneratorService generatorService;

    @PostMapping("/location")
    public ResponseEntity<?> generateData(@RequestBody GeneratorDTO generatorDTO) {
        return ResponseEntity.ok(generatorService.generate(generatorDTO));
    }
}
