package ru.kaam.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrimaryKeyColumn {
    private String columnName;
    private String primaryKeyName;
}