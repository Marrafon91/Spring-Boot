package io.github.marrafon91.uri.repository;

import io.github.marrafon91.uri.entities.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregadoRepository extends JpaRepository<Empregado, String> {
}
