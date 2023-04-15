package ru.kaam.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kaam.backend.dto.RuleDTO;
import ru.kaam.backend.model.Rule;
import ru.kaam.backend.service.RuleService;

import java.util.Optional;

@RestController
@RequestMapping("/rule")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @PostMapping("/add")
    public ResponseEntity<Rule> addRule(@RequestBody RuleDTO ruleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ruleService.addRule(ruleDTO));
    }

    @GetMapping("/get/{ruleId}")
    public ResponseEntity<Rule> getRule(@PathVariable("ruleId") Long id) {
        Optional<Rule> foundRule = ruleService.getRule(id);

        return foundRule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
