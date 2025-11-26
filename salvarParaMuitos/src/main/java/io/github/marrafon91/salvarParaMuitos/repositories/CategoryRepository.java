package io.github.marrafon91.salvarParaMuitos.repositories;

import io.github.marrafon91.salvarParaMuitos.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
