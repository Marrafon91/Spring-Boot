package io.github.marrafon91.salvarParaMuitos.repositories;

import io.github.marrafon91.salvarParaMuitos.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
