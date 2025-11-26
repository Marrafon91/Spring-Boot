package io.github.marrfon91.JPA_SQL_JPQL.repositories;

import io.github.marrfon91.JPA_SQL_JPQL.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
