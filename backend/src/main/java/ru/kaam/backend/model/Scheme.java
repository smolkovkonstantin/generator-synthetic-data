package ru.kaam.backend.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Scheme {
    private String name;
    private List<Table> tables;
}
