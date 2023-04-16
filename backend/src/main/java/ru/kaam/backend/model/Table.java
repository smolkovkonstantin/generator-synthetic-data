package ru.kaam.backend.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Класс описания метаданных таблицы БД
 */
@Data
@Builder
public class Table {
    private String name;
    private String type;
    private List<Column> columns;
    private List<String> primaryKeyForeignTables;
    private List<String> foreignKeys;
}
