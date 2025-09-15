package io.github.marrafon91.libaryapi.repository;

import io.github.marrafon91.libaryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setName("Maria");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1960, 7, 19));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor Salvo: " + autorSalvo);
    }

    @Test
    public void atualizarTest() {
       var id = UUID.fromString("c4351ef2-c8c1-4a9d-aa6c-f0207f8c5900");

       Optional<Autor> possivelAutor = repository.findById(id);

       if (possivelAutor.isPresent()) {

           Autor autorEncontrado = possivelAutor.get();
           System.out.println("Dados do Autor:");
           System.out.println(autorEncontrado);

           autorEncontrado.setDataNascimento(LocalDate.of(1960, 11, 7));

           repository.save(autorEncontrado);
       }
    }

    @Test
    public void listarTest() {
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest() {
        System.out.println("Contagem de autores: " + repository.count());
    }

    @Test
    public void deletePorIdTest() {
        var id = UUID.fromString("804e511f-c719-4411-b0d9-dd0525e977b4");
        repository.deleteById(id);
    }

    @Test
    public void deleteTest() {
        var id = UUID.fromString("c4351ef2-c8c1-4a9d-aa6c-f0207f8c5900");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }

    @Test
    void atualizarAutorDoLivro() {
        UUID id = UUID.fromString("804e511f-c719-4411-b0d9-dd0525e977b4");
        var livroParaAutalizar = repository.findById(id).orElse(null);
    }
}
