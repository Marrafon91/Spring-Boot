package io.github.marrafon91.locadora.model;

import io.github.marrafon91.locadora.model.exceptions.ReservaInvalidaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        //JUnit
        assertThrows(ReservaInvalidaException.class, () -> {
            new Reserva(carro, cliente, 0);
        });

        assertDoesNotThrow(() -> {
            new Reserva(carro, cliente, 1);
        });

        //AsserJ
        var erro = catchThrowable(() -> new Reserva(carro, cliente, 0));

        assertThat(erro)
                .isInstanceOf(ReservaInvalidaException.class)
                .hasMessage("Quantidade de dias inválida");
    }

    @Test
    @DisplayName("Calculando o valor total do Aluguel")
    public void totalAluguel() {
        var reserva = new Reserva(carro, cliente, 3);

        var total = reserva.calcularTotal();

        assertThat(total).isEqualTo(300);
    }

}