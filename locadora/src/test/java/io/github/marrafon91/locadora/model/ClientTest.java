package io.github.marrafon91.locadora.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ClientTest {

    @Test
    @DisplayName("Testando cliente")
    void deveCriarClienteComNome() {
        // 1. Cenario
        var cliente = new Cliente("Maria");

        // 2. Execução
        String nome = cliente.getNome();

        // 3. Verificação

        assertNotNull(nome);

        assertThat(nome).isEqualTo("Maria");
        assertThat(nome).isLessThan("Maria5");

        assertTrue(nome.startsWith("M"));
        assertFalse(nome.length() == 100);

        assertThat(nome.length()).isLessThan(100);
        
        assertThat(nome).contains("Ma");
    }

    @Test
    @DisplayName("Testando cliente")
    void deveCriarClienteSemNome() {
        var cliente = new Cliente(null);

        var nome = cliente.getNome();

        assertNull(nome);
    }
}
