package io.github.marrafon91.libaryapi.repository;

import io.github.marrafon91.libaryapi.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacoesTest {

    @Autowired
    TransacaoService transacaoService;

    /**
     *  Commit -> confirmar as auteracoes
     *  Rollback -> desfazer as alteracoes
     */
    @Test
    void transacaoSimples() {
        // salvar um livro
        // salvar o autor
        // alugar o livro
        // enviar email pro locatario
        // notificar que o livro saiu da livraria
        transacaoService.executar();
    }

    @Test
    void transacaoEstadoManaged() {
        transacaoService.atualizacaoSemAtualizar();
    }
}
