package io.github.marrafon91.libaryapi.service;

import io.github.marrafon91.libaryapi.model.Autor;
import io.github.marrafon91.libaryapi.model.GeneroLivro;
import io.github.marrafon91.libaryapi.model.Livro;
import io.github.marrafon91.libaryapi.repository.AutorRepository;
import io.github.marrafon91.libaryapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    // livro (titulo..., nome_arquivo) -> id.png
    @Transactional
    public void salvarLivroComFoto() {
        // salva o livro
        // repository.save(livro);

        // pega o id do livro = livro.getId();
        // var id = livro.getId();

        // salvar foto do livro -> bucket na nuvem
        // bucketService.salvar(livro.getFoto(), id + ".png");

        // atualizar o nome do arquivo que foi salvo
        // livro.setNomeArquivoFoto(id + ".png");

    }

    @Transactional
    public void atualizacaoSemAtualizar() {
        var livro = livroRepository
                .findById(UUID.fromString("0700ca56-7084-48fe-ae22-5e9c8ec9eea4"))
                .orElse(null);

        livro.setDataPublicacao(LocalDate.of(2024,6,1));
    }

    @Transactional
    public void executar() {
        // salva o autor
        Autor autor = new Autor();
        autor.setNome("Francisca");
        autor.setNacionalidade("Mexicana");
        autor.setDataNascimento(LocalDate.of(1983, 10, 31));

        autorRepository.save(autor);

        //Salva o livro
        Livro livro = new Livro();
        livro.setIsbn("77543-00932");
        livro.setPreco(BigDecimal.valueOf(199));
        livro.setGenero(GeneroLivro.BIOGRAFIA);
        livro.setTitulo("Biografia de Francisca");
        livro.setDataPublicacao(LocalDate.of(2009, 7, 4));

        livro.setAutor(autor);

        livroRepository.save(livro);

        if(autor.getNome().equals("Teste Francisca")) {
            throw new RuntimeException("Rollback!");
        }
    }

}
