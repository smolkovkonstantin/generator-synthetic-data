package ru.kaam.backend.service;

import ru.kaam.backend.dto.RuleDTO;

import java.sql.SQLException;

public interface GeneratorService {

    void generate(RuleDTO ruleDTO) throws SQLException;
}
