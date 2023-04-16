package ru.kaam.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kaam.backend.dto.RuleDTO;
import ru.kaam.backend.model.Rule;
import ru.kaam.backend.service.RuleService;

import java.util.Optional;

/**
 * End points для работы с правилами генерации данных.
 */
@RestController
@RequestMapping("/rule")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @PostMapping()
    public ResponseEntity<Rule> addRule(@RequestBody RuleDTO ruleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ruleService.addRule(ruleDTO));
    }


    @GetMapping("/{ruleId}")
    public ResponseEntity<Rule> getRule(@PathVariable("ruleId") Long id) {
        Optional<Rule> foundRule = ruleService.getRule(id);

        return foundRule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
