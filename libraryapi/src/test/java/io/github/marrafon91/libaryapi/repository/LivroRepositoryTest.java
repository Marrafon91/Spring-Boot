package io.github.marrafon91.libaryapi.repository;

import io.github.marrafon91.libaryapi.model.Autor;
import io.github.marrafon91.libaryapi.model.GeneroLivro;
import io.github.marrafon91.libaryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarTest() {
        Livro livro = new Livro();
        livro.setIsbn("67133-49001");
        livro.setPreco(BigDecimal.valueOf(350));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("50 tons de cinza");
        livro.setDataPublicacao(LocalDate.of(2019, 1, 27));

        Autor autor = autorRepository.
                findById(UUID.fromString("56c8a1fd-cc63-4cf1-b022-167bdda40fa0"))
                .orElse(null);

            livro.setAutor(autor);
        repository.save(livro);
    }

    @Test
    public void salvarAutorELivroTest() {
        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setTitulo("Fabrica de chocolate");
        livro.setDataPublicacao(LocalDate.of(1999, 10, 14));

        Autor autor = new Autor();
        autor.setNome("Anderson");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1943, 8, 31));

        autorRepository.save(autor);

        livro.setAutor(autor);

        repository.save(livro);
    }

    @Test
    public void salvarCascadeTest() {
        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setTitulo("Senhor dos Aneis");
        livro.setDataPublicacao(LocalDate.of(1995, 1, 2));

        Autor autor = new Autor();
        autor.setNome("João");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1960, 7, 19));

        livro.setAutor(autor);

        repository.save(livro);
    }

    @Test
    void atualizarAutorDoLivro() {
        UUID id = UUID.fromString("c6f60b39-938a-4aef-a06b-91c34630cef8");
        var livroParaAtualizar = repository.findById(id).orElse(null);

        UUID idAutor = UUID.fromString("c6f60b39-938a-4aef-a06b-91c34630cef8");
        Autor maria = autorRepository.findById(idAutor).orElse(null);

        livroParaAtualizar.setAutor(maria);

        repository.save(livroParaAtualizar);
    }

    @Test
    void deletar() {
        UUID id = UUID.fromString("804e511f-c719-4411-b0d9-dd0525e977b4");
        repository.deleteById(id);
    }
    //Deleta todos se tiver cascade setado na entidade.
    //@ManyToOne(cascade = CascadeType.ALL)
    @Test
    void deletarCascada() {
        UUID id = UUID.fromString("804e511f-c719-4411-b0d9-dd0525e977b4");
        repository.deleteById(id);
    }

    @Test
    @Transactional
    void buscarLivroTest() {
        UUID id = UUID.fromString("647cd6db-d2f7-4b49-be0e-a64b0cf6b506");
        Livro livro = repository.findById(id).orElse(null);

        System.out.println("Livro: ");
        System.out.println(livro.getTitulo());
//        System.out.println("Autor: ");
//        System.out.println(livro.getAutor().getName());
    }

    @Test
    void pesquisaPorTituloTest() {
        List<Livro> lista = repository.findByTitulo("O roubo a casa assombrada");
        lista.forEach(System.out::println);
    }

    @Test
    void pesquisaPorIsbnTest() {
        Optional<Livro> livro = repository.findByIsbn("76533-87114");
        livro.ifPresent(System.out::println);
    }

    @Test
    void pesquisaPorTituloAndPreco() {
        BigDecimal preco = BigDecimal.valueOf(100.00);
        String TituloPesquisa = "Senhor dos Aneis";

        List<Livro> lista = repository.findByTituloAndPreco(TituloPesquisa, preco);
        lista.forEach(System.out::println);
    }

    @Test
    void listarLivrosComQueryJPQL() {
        var resultado = repository.listarTodosOrdenadoPorTituloAndPreco();
        resultado.forEach(System.out::println);
    }

    @Test
    void listarAutoresDosLivros() {
        var resultado = repository.listarAutoresDosLivros();
        resultado.forEach(System.out::println);
    }

//    @Test
//    void listarTitulosNaoRepetidosDosLivros() {
//        var resultado = repository.listarNomesDiferentesLivros();
//        resultado.forEach(System.out::println);
//    }

    @Test
    void listarGenerosDeLivrosAutoresBrasileiros() {
        var resultado = repository.listarGeneroAutoresBrasileiros();
        resultado.forEach(System.out::println);
    }

    @Test
    void listarPorGeneroQueryParamTest() {
        var resultado = repository.findByGenero(GeneroLivro.FANTASIA, "preco");
        resultado.forEach(System.out::println);
    }

    @Test
    void listarPorGeneroPositionalParamTest() {
        var resultado = repository.findByGeneroPositionalParameters(GeneroLivro.FANTASIA, "preco");
        resultado.forEach(System.out::println);
    }

    @Test
    void deletePorGeneroTest() {
        repository.deleteByGenero(GeneroLivro.CIENCIA);
    }

    @Test
    void updateDataPublicacaoTest() {
        repository.updateDataPuplicacao(LocalDate.of(2000,1, 1));
    }

}