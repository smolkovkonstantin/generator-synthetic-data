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

@RestController
@RequestMapping("/rule")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @Operation(summary = "Добавление правила")
    @ApiResponse(
            responseCode = "201",
            description = "Правило сохранено",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = Rule.class
                            )
                    )})
    @ApiResponse(
            responseCode = "400",
            description = "Правило введено неверно"
    )
    @PostMapping()
    public ResponseEntity<Rule> addRule(@RequestBody RuleDTO ruleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ruleService.addRule(ruleDTO));
    }

    @Operation(summary = "Получение правила")
    @ApiResponse(
            responseCode = "200",
            description = "Правило получено",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = Rule.class
                            )
                    )})
    @ApiResponse(
            responseCode = "404",
            description = "Правило не найдено"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Параметр ruleId < 0 или null"
    )
    @GetMapping("/{ruleId}")
    public ResponseEntity<Rule> getRule(@PathVariable("ruleId") Long id) {
        Optional<Rule> foundRule = ruleService.getRule(id);

        return foundRule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
