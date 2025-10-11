package io.github.marrafon91.libaryapi.repository;

import io.github.marrafon91.libaryapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Usuario findByLogin(String login);
}
