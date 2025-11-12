package io.github.marrafon91.locadora.service;

import io.github.marrafon91.locadora.entity.CarroEntity;
import io.github.marrafon91.locadora.repository.CarroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CarroServiceTest {

    @InjectMocks
    CarroService service;

    @Mock
    CarroRepository repository;

    @Test
    void deveSalvarUmCarro() {

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(new CarroEntity("Mock Sedan",100.00,2026)));

        Optional<CarroEntity> carroEncontrado = repository.findById(1L);
        System.out.println(carroEncontrado.get().getModelo());
        System.out.println(carroEncontrado.get().getValorDiario());
        System.out.println(carroEncontrado.get().getAno());
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