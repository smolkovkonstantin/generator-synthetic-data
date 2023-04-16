package ru.kaam.backend.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kaam.backend.dto.RuleDTO;
import ru.kaam.backend.service.GeneratorService;

import java.sql.SQLException;

/**
 * End points для генерации синтетических данных.
 */
@RestController
@RequestMapping("/generate")
@RequiredArgsConstructor
public class GeneratorController {

    private final GeneratorService generatorService;

    @ApiResponse(
            responseCode = "200",
            description = "Синтетические данные сгенерированы"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Правила указаны неверно"
    )
    @PostMapping
    public void generateData(@RequestBody RuleDTO ruleDTO) throws SQLException {
        generatorService.generate(ruleDTO);
    }
}
