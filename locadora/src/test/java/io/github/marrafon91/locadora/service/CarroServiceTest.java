package io.github.marrafon91.locadora.service;

import io.github.marrafon91.locadora.entity.CarroEntity;
import io.github.marrafon91.locadora.repository.CarroRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class CarroServiceTest {

    @InjectMocks
    CarroService service;

    @Mock
    CarroRepository repository;

    @Test
    void SalvarUmCarro() {
        CarroEntity carroParaSalvar = new CarroEntity("Sedan",100.00,2026);
        carroParaSalvar.setId(1L);

        CarroEntity carroParaRetornar = new CarroEntity("Sedan",200.00,2026);
        carroParaRetornar.setId(1L);

        Mockito.when(repository.save(Mockito.any()))
                .thenReturn(carroParaRetornar);

         var carroSalvo = service.salvar(carroParaSalvar);

        assertNotNull(carroSalvo);
        assertEquals("Sedan",carroSalvo.getModelo());

        Mockito.verify(repository).save(Mockito.any());
    }

    @Test
    @DisplayName("Teste que deve dar erro ao tentar salvar um carro qual a diaria é negativa")
    void diariaNegativa() {
        CarroEntity carro = new CarroEntity("Sedan",0,2026);

        var erro = catchThrowable(() -> service.salvar(carro));

        assertThat(erro).isInstanceOf(IllegalArgumentException.class);

        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
    }
}