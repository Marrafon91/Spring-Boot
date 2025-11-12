package io.github.marrafon91.locadora.service;

import io.github.marrafon91.locadora.entity.CarroEntity;
import io.github.marrafon91.locadora.repository.CarroRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CarroServiceTest {

    @InjectMocks
    CarroService service;

    @Mock
    CarroRepository repository;

    @Test
    void deveSalvarUmCarro() {
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
    void atualizar() {
    }

    @Test
    void deletar() {
    }

    @Test
    void buscarPorId() {
    }

    @Test
    void listarTodos() {
    }
}