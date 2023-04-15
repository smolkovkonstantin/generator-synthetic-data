package ru.kaam.backend.model;

import lombok.Data;

import java.util.List;

@Data
public class Scheme {
    private String name;
    private List<Table> tables;
}
