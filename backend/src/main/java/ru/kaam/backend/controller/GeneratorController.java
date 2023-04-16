package ru.kaam.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kaam.backend.dto.RuleDTO;
import ru.kaam.backend.service.GeneratorService;

@RestController
@RequestMapping("/generate")
@RequiredArgsConstructor
public class GeneratorController {

    private final GeneratorService generatorService;

    @PostMapping()
    public ResponseEntity<?> generateData(@RequestBody RuleDTO ruleDTO) {
        return ResponseEntity.ok(generatorService.generate(ruleDTO));
    }
}
