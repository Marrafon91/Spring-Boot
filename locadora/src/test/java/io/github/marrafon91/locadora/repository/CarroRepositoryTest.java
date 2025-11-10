package io.github.marrafon91.locadora.repository;

import io.github.marrafon91.locadora.entity.CarroEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class CarroRepositoryTest {

   @Autowired
   CarroRepository repository;

   CarroEntity carro;

   @BeforeEach
   void setUP() {
       carro = new CarroEntity("Honda Civic", 200.00, 2026);
   }

    @Test
    void deveSalvarUmCarro() {
        var entity = new CarroEntity("Sedan", 100.00, 2025);
        repository.save(entity);

        Assertions.assertNotNull(entity.getId());
    }

    @Test
    void buscarCarroPorId() {
        var carroSalvo = repository.save(carro);

        Optional<CarroEntity> carroEncontrado = repository.findById(carroSalvo.getId());

        assertThat(carroEncontrado).isPresent();
        assertThat(carroEncontrado.get().getModelo()).isEqualTo("Honda Civic");
    }

    @Test
    void atualizarCarro() {
        var carroSalvo = repository.save(carro);
        carroSalvo.setAno(2028);

        var carroAtualizado = repository.save(carroSalvo);

        assertThat(carroAtualizado.getAno()).isEqualTo(2028);
    }

    @Test
    void deletarCarro() {
        var carroSalvo = repository.save(carro);
        repository.deleteById(carroSalvo.getId());

        Optional<CarroEntity> carroEncontrado = repository.findById(carroSalvo.getId());

        assertThat(carroEncontrado.isEmpty());
    }
}