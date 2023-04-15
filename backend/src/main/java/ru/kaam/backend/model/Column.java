package ru.kaam.backend.model;

import lombok.Data;

@Data
public class Column {
    private String name;
    private String type;
    private Integer size;
    private Boolean isNullable;
    private Boolean isAutoIncrement;
}
