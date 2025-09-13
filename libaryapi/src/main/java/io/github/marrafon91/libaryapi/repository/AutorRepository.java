package io.github.marrafon91.libaryapi.repository;

import io.github.marrafon91.libaryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
