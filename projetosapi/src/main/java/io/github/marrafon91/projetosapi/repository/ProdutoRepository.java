package io.github.marrafon91.projetosapi.repository;

import io.github.marrafon91.projetosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
