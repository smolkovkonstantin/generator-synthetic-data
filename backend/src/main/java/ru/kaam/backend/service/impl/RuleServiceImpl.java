package ru.kaam.backend.service.impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.kaam.backend.dto.RuleDTO;
import ru.kaam.backend.model.Rule;
import ru.kaam.backend.repository.RuleRepository;
import ru.kaam.backend.service.RuleService;

import java.util.Optional;

@Service
@Validated
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService {

    private final RuleRepository ruleRepository;

    @Override
    public Optional<Rule> getRule(@NotNull @Positive Long id) {
        return ruleRepository.findById(id);
    }

    @Override
    public Rule addRule(@Valid RuleDTO ruleDTO) {
        return ruleRepository.save(convertToEntity(ruleDTO));
    }

    private Rule convertToEntity(RuleDTO ruleDTO) {
        return Rule.builder()
                .numOfEntities(ruleDTO.numOfEntities())
                .mask(ruleDTO.mask())
                .build();
    }
}
