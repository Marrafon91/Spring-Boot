package io.github.marrafon91.projetosapi.repository;

import io.github.marrafon91.projetosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);
}
