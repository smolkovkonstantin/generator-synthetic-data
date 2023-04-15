package ru.kaam.backend.service.impl;

import ru.kaam.backend.model.Scheme;
import ru.kaam.backend.model.Table;
import ru.kaam.backend.service.SchemeService;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SchemeServiceImpl implements SchemeService {
    @Override
    public Scheme getScheme() throws SQLException {
        ResultSet resultSet;
        DatabaseMetaData databaseMetaData = null;
        return null;
    }

    private List<Table> setTables(DatabaseMetaData databaseMetaData) throws SQLException {

        ResultSet tables = databaseMetaData.getTables(null, null, null, null);

        while (tables.next()) {
            ResultSet columns = databaseMetaData.getColumns(null, null, tables.getString("TABLE_NAME "), null);
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_TYPE");
                String columnSize = columns.getString("COLUMN_SIZE");
                String datatype = columns.getString("DATA_TYPE");
                String isNullable = columns.getString("IS_NULLABLE");
                String isAutoIncrement = columns.getString("IS_AUTOINCREMENT");
            }
        }


        return null;
    }
}
