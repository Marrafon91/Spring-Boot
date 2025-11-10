package io.github.marrafon91.locadora.model;

import io.github.marrafon91.locadora.model.exceptions.ReservaInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {

    Cliente cliente;
    Carro carro;

    @BeforeEach // inicia a variavel antes da execucao
    void setUp() {
        cliente = new Cliente("Maria");
        carro = new Carro("Sedan", 100.00);
    }

    @Test
    @DisplayName("Test da reserva")
    public void criarReserva() {
        // cenario
        var dias = 5;

        // execucao
        var reserva = new Reserva(carro, cliente, dias);

        // vereficacao
        assertThat(reserva).isNotNull();
    }

    @Test
    @DisplayName("Test da reserva com dias inválidos")
    public void reservaDiasInvalidos() {
        Carro carro = new Carro("Sedan", 100.00);

        Assertions.assertThrows(ReservaInvalidaException.class, () -> {
            carro.calcularValorAluguel(0);
        });
    }

    @Test
    @DisplayName("")
    public void totalAluguel() {

    }

}