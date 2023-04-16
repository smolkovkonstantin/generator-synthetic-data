package ru.kaam.backend.service;

import ru.kaam.backend.dto.RuleDTO;

public interface GeneratorService {

    Object generate(RuleDTO ruleDTO);
}
