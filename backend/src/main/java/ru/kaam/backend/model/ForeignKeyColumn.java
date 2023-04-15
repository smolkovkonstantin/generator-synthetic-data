package ru.kaam.backend.model;

import lombok.Data;

@Data
public class ForeignKeyColumn {
    private String pkTableName;
    private String fkTableName;
    private String pkColumnName;
    private String fkColumnName;
}
