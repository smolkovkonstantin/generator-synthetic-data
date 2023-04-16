package ru.kaam.backend.service.impl;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.kaam.backend.dto.RuleDTO;
import ru.kaam.backend.service.GeneratorService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
@RequiredArgsConstructor
public class GeneratorServiceImpl implements GeneratorService {

    private final ApplicationContext context;

    @Override
    public Object generate(RuleDTO ruleDTO) {
        Faker faker = new Faker();

        Connection connection = (Connection) context.getBean("connection");
        try (Statement statement = connection.createStatement()) {

            for (long i = 0; i < ruleDTO.numOfEntities(); i++) {
                Long latitude = faker.number().randomNumber();
                Long longitude = faker.number().randomNumber();

                statement.execute("INSERT INTO location_point(latitude, longitude)"
                        + String.format(" VALUES (%s, %s)", latitude, longitude));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
