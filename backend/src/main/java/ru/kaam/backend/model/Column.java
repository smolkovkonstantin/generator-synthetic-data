package ru.kaam.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Column {
    private String name;
    private String type;
    private Integer size;
    private Boolean isNullable;
    private Boolean isAutoIncrement;
    private Boolean isGeneratedColumn;
    private Boolean isPrimaryKey;
}
