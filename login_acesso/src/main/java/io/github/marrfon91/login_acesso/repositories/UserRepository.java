package io.github.marrfon91.login_acesso.repositories;

import io.github.marrfon91.login_acesso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
