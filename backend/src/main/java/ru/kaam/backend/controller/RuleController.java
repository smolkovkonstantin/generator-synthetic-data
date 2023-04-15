package ru.kaam.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kaam.backend.dto.RuleDTO;

@RestController
@RequestMapping("/rule")
public class RuleController {

    @PostMapping("/add")
    public ResponseEntity<?> addRule(@RequestBody RuleDTO ruleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
