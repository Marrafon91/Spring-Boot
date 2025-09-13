package io.github.marrafon91.libaryapi.repository;

import io.github.marrafon91.libaryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
