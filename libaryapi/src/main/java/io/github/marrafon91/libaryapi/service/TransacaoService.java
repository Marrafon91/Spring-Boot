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

@Service
public class TransacaoService {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @Transactional
    public void executar() {
        // salva o autor
        Autor autor = new Autor();
        autor.setName("Teste Francisca");
        autor.setNacionalidade("Mexicana");
        autor.setDataNascimento(LocalDate.of(1983, 10, 31));

        autorRepository.save(autor);

        //Salva o livro
        Livro livro = new Livro();
        livro.setIsbn("77543-00932");
        livro.setPreco(BigDecimal.valueOf(199));
        livro.setGenero(GeneroLivro.BIOGRAFIA);
        livro.setTitulo("Teste Biografia de Francisca");
        livro.setDataPublicacao(LocalDate.of(2009, 7, 4));

        livro.setAutor(autor);

        livroRepository.save(livro);

        if(autor.getName().equals("Teste Francisca")) {
            throw new RuntimeException("Rollback!");
        }
    }

}
