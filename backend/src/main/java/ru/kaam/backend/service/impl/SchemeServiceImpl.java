package ru.kaam.backend.service.impl;

import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
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

@Service
@Validated
@Slf4j
public class SchemeServiceImpl implements SchemeService {

    private final ApplicationContext context;

    @Autowired
    public SchemeServiceImpl(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Scheme getScheme() throws SQLException {

        Connection connection = (Connection) context.getBean("connection");

        DatabaseMetaData databaseMetaData = connection.getMetaData();
        return Scheme.builder()
                .name("Test")
                .tables(setTables(databaseMetaData))
                .build();
    }

    @Override
    public Table getTable(@NotBlank String tableName) throws SQLException {
        Connection connection = (Connection) context.getBean("connection");
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        return Table.builder()
                .name(tableName)
                .columns(setColumns(databaseMetaData, tableName))
                .build();
    }

    private List<Table> setTables(DatabaseMetaData databaseMetaData) throws SQLException {
        List<Table> tables = new ArrayList<>();
        ResultSet foundTables = databaseMetaData.getTables(null, "public", null, null);

        while (foundTables.next()) {
            String tableType = foundTables.getString("TABLE_TYPE");
            String tableName = foundTables.getString("TABLE_NAME");

            if (tableType.equals("TABLE")) {

                ResultSet foundImportedKeys = databaseMetaData.getImportedKeys(null, null, tableName);
                List<String> foreignKeys = new ArrayList<>();
                List<String> primaryKeyForeignTables = new ArrayList<>();

                while (foundImportedKeys.next()) {
                    String primaryKeyForeignTable;
                    String foreignKey;

                    foreignKey = foundImportedKeys.getString("FKCOLUMN_NAME");
                    primaryKeyForeignTable = foundImportedKeys.getString("PKCOLUMN_NAME");
                    if (!foreignKey.isEmpty()) {
                        foreignKeys.add(foreignKey);
                    }
                    if (!primaryKeyForeignTable.isEmpty()) {
                        primaryKeyForeignTables.add(tableName);
                    }
                }

                List<Column> columns = setColumns(databaseMetaData, tableName);

                Table table = Table.builder()
                        .name(foundTables.getString("TABLE_NAME"))
                        .type(tableType)
                        .columns(columns)
                        .primaryKeyForeignTables(primaryKeyForeignTables)
                        .foreignKeys(foreignKeys)
                        .build();

                tables.add(table);
            }
        }

        return tables;
    }

    private List<Column> setColumns(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
        List<Column> columns = new ArrayList<>();
        ResultSet foundPrimaryKeys = databaseMetaData.getPrimaryKeys(null, null, tableName);
        ResultSet foundColumns = databaseMetaData.getColumns(null, null, tableName, null);

        boolean isPrimaryKey = false;

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

            Column column = Column.builder()
                    .name(columnName)
                    .size(Integer.parseInt(columnSize))
                    .type(datatype)
                    .isNullable(Boolean.parseBoolean(isNullable))
                    .isAutoIncrement(Boolean.parseBoolean(isAutoIncrement))
                    .isGeneratedColumn(Boolean.parseBoolean(isGeneratedColumn))
                    .isPrimaryKey(isPrimaryKey)
                    .build();
            columns.add(column);
        }

        return columns;
    }
}
