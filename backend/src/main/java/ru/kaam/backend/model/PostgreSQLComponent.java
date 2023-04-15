package ru.kaam.backend.model;

import lombok.Getter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PostgreSQLComponent {
    private JdbcTemplate jdbcTemplate;

    public void init(String url, String userName, String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("org.postgresql.Driver");
        jdbcTemplate.setDataSource(dataSource);
    }
}
