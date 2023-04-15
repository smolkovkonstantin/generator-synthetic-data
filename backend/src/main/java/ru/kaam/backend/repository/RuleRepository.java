package ru.kaam.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kaam.backend.model.Rule;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {
}
