package ru.kaam.backend.service;

import ru.kaam.backend.dto.GeneratorDTO;

public interface GeneratorService {

    Object generate(GeneratorDTO generatorDTO);
}
