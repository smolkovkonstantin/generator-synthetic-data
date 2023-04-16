package ru.kaam.backend.service.impl;

import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.kaam.backend.model.Column;
import ru.kaam.backend.model.Scheme;
import ru.kaam.backend.model.Table;
import ru.kaam.backend.service.SchemeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для получения метаданных о базе данных.
 */
@Service
@Validated
public class SchemeServiceImpl implements SchemeService {

    private final ApplicationContext context;

    @Autowired
    public SchemeServiceImpl(ApplicationContext context) {
        this.context = context;
    }

    /**
     * Получение логической схемы БД
     * @return Scheme - логическая модель БД
     */
    @Override
    public Scheme getScheme() throws SQLException {

        Connection connection = (Connection) context.getBean("connection");

        DatabaseMetaData databaseMetaData = connection.getMetaData();
        return Scheme.builder()
                .name("Test")
                .tables(setTables(databaseMetaData))
                .build();
    }

    /**
     * Получение таблицы БД
     * @return Table - модель таблицы БД
     */
    @Override
    public Table getTable(@NotBlank String tableName) throws SQLException {
        Connection connection = (Connection) context.getBean("connection");
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        return Table.builder()
                .name(tableName)
                .columns(setColumns(databaseMetaData, tableName))
                .build();
    }

    /**
     * Формирование списка метаданных таблиц
     */
    private List<Table> setTables(DatabaseMetaData databaseMetaData) throws SQLException {
        List<Table> tables = new ArrayList<>();

        ResultSet foundTables = databaseMetaData.getTables(null, "public", null, null);

        while (foundTables.next()) {
            String tableType = foundTables.getString("TABLE_TYPE");
            String tableName = foundTables.getString("TABLE_NAME");

            if (tableType.equals("TABLE")) {
                List<Column> columns = setColumns(databaseMetaData, tableName);

                Table table = Table.builder()
                        .name(foundTables.getString("TABLE_NAME"))
                        .type(tableType)
                        .columns(columns)
                        .build();

                tables.add(table);
            }
        }

        return tables;
    }

    /**
     * Формирование списка метаданных о колонках таблицы
     */
    private List<Column> setColumns(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
        List<Column> columns = new ArrayList<>();
        ResultSet foundPrimaryKeys = databaseMetaData.getPrimaryKeys(null, null, tableName);
        ResultSet foundImportedKeys = databaseMetaData.getImportedKeys(null, null, tableName);
        ResultSet foundExportedKeys = databaseMetaData.getExportedKeys(null, null, tableName);
        ResultSet foundColumns = databaseMetaData.getColumns(null, null, tableName, null);

        boolean isPrimaryKey = false;
        boolean isImportedForeignKey = false;
        boolean isExportedForeignKey = false;

        while (foundColumns.next()) {


            String columnName = foundColumns.getString("COLUMN_NAME");
            String columnSize = foundColumns.getString("COLUMN_SIZE");
            String datatype = JDBCType.valueOf(Integer.parseInt(foundColumns.getString("DATA_TYPE"))).name();
            String isNullable = foundColumns.getString("IS_NULLABLE");
            String isAutoIncrement = foundColumns.getString("IS_AUTOINCREMENT");
            String isGeneratedColumn = foundColumns.getString("IS_GENERATEDCOLUMN");

            while (foundPrimaryKeys.next()) {
                if (foundPrimaryKeys.getString("COLUMN_NAME").equals(columnName)) {
                    isPrimaryKey = true;
                }
            }

            while (foundImportedKeys.next()) {
                if (foundImportedKeys.getString("FKCOLUMN_NAME").equals(columnName)) {
                    isImportedForeignKey = true;
                }
            }

            while (foundExportedKeys.next()) {
                if (foundExportedKeys.getString("FKCOLUMN_NAME").equals(columnName)) {
                    isExportedForeignKey = true;
                }
            }

            Column column = Column.builder()
                    .name(columnName)
                    .size(Integer.parseInt(columnSize))
                    .type(datatype)
                    .isNullable(Boolean.parseBoolean(isNullable))
                    .isAutoIncrement(Boolean.parseBoolean(isAutoIncrement))
                    .isGeneratedColumn(Boolean.parseBoolean(isGeneratedColumn))
                    .isPrimaryKey(isPrimaryKey)
                    .isImportedForeignKey(isImportedForeignKey)
                    .isExportedForeignKey(isExportedForeignKey)
                    .build();
            columns.add(column);
        }

        return columns;
    }
}
