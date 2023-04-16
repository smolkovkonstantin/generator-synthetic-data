package ru.kaam.backend.dto;

import ru.kaam.backend.model.ColumnRule;
import ru.kaam.backend.model.Rule;

import java.util.List;

public record RuleDTO(
        Long numOfEntities,
        String tableName,
        List<ColumnRule> rules) {
}
