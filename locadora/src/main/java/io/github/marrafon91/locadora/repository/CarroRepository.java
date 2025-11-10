package io.github.marrafon91.locadora.repository;

import io.github.marrafon91.locadora.entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<CarroEntity, Long> {
}
