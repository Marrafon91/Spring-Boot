package io.github.marrafon91.libaryapi.repository;

import io.github.marrafon91.libaryapi.model.Autor;
import io.github.marrafon91.libaryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    //@Querry Method
    //select * from livro where id_autor = id
    List<Livro> findByAutor(Autor autor);

    //select * from livro where titulo = ?
    List<Livro> findByTitulo(String titulo);

    //select * from livro where isbn = ?
    List<Livro> findByIsbn(String isbn);

    //select * from livro where titulo = ? and preco = ?
    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);
    
    //select * from livro where titulo = ? or isbn = ?
    List<Livro> findByTituloOrIsbn(String titulo, String isbn);
}
