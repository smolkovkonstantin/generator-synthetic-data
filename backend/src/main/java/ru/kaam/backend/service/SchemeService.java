package ru.kaam.backend.service;

import jakarta.validation.constraints.NotBlank;
import ru.kaam.backend.model.Scheme;
import ru.kaam.backend.model.Table;

import java.sql.SQLException;

public interface SchemeService {

    Scheme getScheme() throws SQLException;

    Table getTable(@NotBlank String tableName) throws SQLException;

}
