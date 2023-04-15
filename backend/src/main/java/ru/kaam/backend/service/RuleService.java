package ru.kaam.backend.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ru.kaam.backend.dto.RuleDTO;
import ru.kaam.backend.model.Rule;

import java.util.Optional;

public interface RuleService {
    Optional<Rule> getRule(@NotNull @Positive Long id);

    Rule addRule(@Valid RuleDTO ruleDTO);
}
