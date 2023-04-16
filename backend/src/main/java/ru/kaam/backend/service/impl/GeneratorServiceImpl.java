package ru.kaam.backend.service.impl;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.kaam.backend.dto.RuleDTO;
import ru.kaam.backend.model.ColumnRule;
import ru.kaam.backend.service.GeneratorService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;

/**
 * Сервис для генерации случайных данных
 */

@Service
@RequiredArgsConstructor
public class GeneratorServiceImpl implements GeneratorService {

    private final ApplicationContext context;

    /**
     * Герерация случайных данных на основе правил переданных
     * Данные сразу сохраняются в базу данных
     * @param ruleDTO - передеанные правила генерации, содержащий информацию о названии таблицы,
     *                названии колонок, а также маску, заданнуюпользователем
     */
    @Override
    public void generate(RuleDTO ruleDTO) throws SQLException {

        Connection connection = (Connection) context.getBean("connection");

        Statement statement = connection.createStatement();
            for (long i = 0; i < ruleDTO.numOfEntities(); i++) {
                statement.execute(generateInsertQuery(ruleDTO.tableName(), ruleDTO.rules()));
            }
    }


    /**
     * Построение запроса insert для любой переданной колонки
     * @param tableName - название таблицы
     * @param columnRule - колонки и маски для генерации данных
     * @return сткрока для исполнения запроса insert
     * @throws SQLException
     */

    public static String generateInsertQuery(String tableName, List<ColumnRule> columnRule) throws SQLException {
        // Создаем SQL-запрос на основе переданных названий столбцов и значений
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(tableName).append(" (");

        // Добавляем названия столбцов в запрос
        for (int i = 0; i < columnRule.size(); i++) {
            sb.append(columnRule.get(i).getNameOfColumn());
            if (i < columnRule.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append(") VALUES (");

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String value;

        // Добавляем значения в запрос
        for (int i = 0; i < columnRule.size(); i++) {

            value = fakeValuesService.bothify(parseMask(columnRule.get(i).getMask()));
            sb.append("'").append(value).append("'");
            if (i < columnRule.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append(")");

        return sb.toString().replaceAll("ь", "?").replaceAll("ъ", "#");
    }


    /**
     * Парсинг маски для случаев, когда mask содержит [number] - повторение, \? и \# - экранироваение
     */
    private static String parseMask(String mask) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder multiplier = new StringBuilder("1");
        char previous = '0';
        boolean isDigitForMultiplier = false;

        // parse [number]

        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == '[' && i != 0) {
                previous = mask.charAt(i - 1);
                multiplier = new StringBuilder();
                isDigitForMultiplier = true;
            } else if (mask.charAt(i) == ']') {
                isDigitForMultiplier = false;
                stringBuilder.append(String.valueOf(previous).repeat(Math.max(0, Integer.parseInt(multiplier.toString()) - 1)));
                multiplier = new StringBuilder("1");
            } else if (isDigitForMultiplier) {
                multiplier.append(mask.charAt(i));
            } else {
                stringBuilder.append(mask.charAt(i));
                previous = mask.charAt(i);
            }
        }

        // parse \? \#

        return stringBuilder.toString().replaceAll("(\\\\\\?)", "ь").replaceAll("\\\\#", "ъ");
    }
}
