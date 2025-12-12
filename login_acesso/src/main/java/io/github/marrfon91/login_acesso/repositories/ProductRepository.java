package io.github.marrfon91.login_acesso.repositories;

import io.github.marrfon91.login_acesso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
