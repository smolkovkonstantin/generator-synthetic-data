package ru.kaam.backend.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import ru.kaam.backend.dto.ConnectorDTO;
import ru.kaam.backend.service.ConnectorService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class ConnectorServiceImpl implements ConnectorService {
}
