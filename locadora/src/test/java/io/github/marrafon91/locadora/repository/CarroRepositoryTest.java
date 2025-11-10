package io.github.marrafon91.locadora.repository;

import io.github.marrafon91.locadora.entity.CarroEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class CarroRepositoryTest {

   @Autowired
   CarroRepository repository;

    @Test
    void deveSalvarUmCarro() {
        var entity = new CarroEntity("Sedan", 100.00);

        repository.save(entity);

        Assertions.assertNotNull(entity.getId());
    }
}