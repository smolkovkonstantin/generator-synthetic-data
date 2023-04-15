package ru.kaam.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kaam.backend.dto.RuleDTO;
import ru.kaam.backend.service.RuleService;

@RestController
@RequestMapping("/rule")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @PostMapping("/add")
    public ResponseEntity<?> addRule(@RequestBody RuleDTO ruleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get")
    public ResponseEntity<?> getRule() {
        return ResponseEntity.ok().build();
    }

}
