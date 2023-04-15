package ru.kaam.backend.service.impl;

import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kaam.backend.model.Column;
import ru.kaam.backend.model.Scheme;
import ru.kaam.backend.model.Table;
import ru.kaam.backend.service.SchemeService;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchemeServiceImpl implements SchemeService {

    private Connection connection;

    @Autowired
    public SchemeServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Scheme getScheme() throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        return Scheme.builder()
                .name("Test")
                .tables(setTables(databaseMetaData))
                .build();
    }

    @Override
    public Table getTable(@NotBlank String tableName) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet foundColumns = databaseMetaData.getColumns(null, null, tableName, null);

        return Table.builder()
                .name(tableName)
                .columns(setColumns(foundColumns))
                .build();
    }

    private List<Table> setTables(DatabaseMetaData databaseMetaData) throws SQLException {
        List<Table> tables = new ArrayList<>();
        ResultSet foundTables = databaseMetaData.getTables(null, null, null, null);

        while (foundTables.next()) {
            ResultSet foundColumns = databaseMetaData.getColumns(null, null, foundTables.getString("TABLE_NAME "), null);

            List<Column> columns = setColumns(foundColumns);

            Table table = Table.builder()
                    .name(foundTables.getString("TABLE_NAME"))
                    .columns(columns)
                    .build();

            tables.add(table);
        }

        return tables;
    }

    private List<Column> setColumns(ResultSet foundColumns) throws SQLException {
        List<Column> columns = new ArrayList<>();

        while (foundColumns.next()) {
            String columnName = foundColumns.getString("COLUMN_TYPE");
            String columnSize = foundColumns.getString("COLUMN_SIZE");
            String datatype = foundColumns.getString("DATA_TYPE");
            String isNullable = foundColumns.getString("IS_NULLABLE");
            String isAutoIncrement = foundColumns.getString("IS_AUTOINCREMENT");

            Column column = Column.builder()
                    .name(columnName)
                    .size(Integer.parseInt(columnSize))
                    .type(datatype)
                    .isNullable(Boolean.parseBoolean(isNullable))
                    .isAutoIncrement(Boolean.parseBoolean(isAutoIncrement))
                    .build();
            columns.add(column);
        }

        return columns;
    }
}
