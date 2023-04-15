package ru.kaam.backend.service;

import ru.kaam.backend.model.Scheme;

import java.sql.SQLException;

public interface SchemeService {

    Scheme getScheme() throws SQLException;

}
