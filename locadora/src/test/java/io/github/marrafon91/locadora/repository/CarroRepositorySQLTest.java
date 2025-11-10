package io.github.marrafon91.locadora.repository;

import io.github.marrafon91.locadora.entity.CarroEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class CarroRepositorySQLTest {

    @Autowired
    CarroRepository repository;

    @Test
    @Sql("/sql/popular-carros.sql")
    void buscarCarroPorModelo() {
        List<CarroEntity> lista = repository.findByModelo("SUV");

        var carro = lista.stream().findFirst().get();

        assertEquals(1, lista.size());

        assertThat(carro.getValorDiario()).isEqualTo(150.00);
        assertThat(carro.getModelo()).isEqualTo("SUV");
    }
}
