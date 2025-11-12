package io.github.marrafon91.locadora.service;

import io.github.marrafon91.locadora.entity.CarroEntity;
import io.github.marrafon91.locadora.model.exception.EntityNotFoundException;
import io.github.marrafon91.locadora.repository.CarroRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CarroServiceTest {

    @InjectMocks
    CarroService service;

    @Mock
    CarroRepository repository;

    @Test
    @DisplayName("Testa para salvar um carro")
    void SalvarUmCarro() {
        CarroEntity carroParaSalvar = new CarroEntity("Sedan",100.00,2026);
        carroParaSalvar.setId(1L);

        CarroEntity carroParaRetornar = new CarroEntity("Sedan",200.00,2026);
        carroParaRetornar.setId(1L);

        when(repository.save(any()))
                .thenReturn(carroParaRetornar);

         var carroSalvo = service.salvar(carroParaSalvar);

        assertNotNull(carroSalvo);
        assertEquals("Sedan",carroSalvo.getModelo());

        verify(repository).save(any());
    }

    @Test
    @DisplayName("Teste que deve dar erro ao tentar salvar um carro qual a diaria é negativa")
    void diariaNegativa() {
        CarroEntity carro = new CarroEntity("Sedan",0,2026);

        var erro = catchThrowable(() -> service.salvar(carro));

        assertThat(erro).isInstanceOf(IllegalArgumentException.class);

        verify(repository, never()).save(any());
    }

    @Test
    @DisplayName("Teste de Mockito para atualizar o carro!")
    void atualizarCarro() {
        var carroExistente = new CarroEntity("Gol", 80.00,2026);
        when(repository.findById(1L)).thenReturn(Optional.of(carroExistente));

        var carroAtualizado = new CarroEntity("Gol", 80.00,2026);
        carroAtualizado.setId(1L);
        when(repository.save(any())).thenReturn(carroAtualizado);

        Long id = 1L;
        var carro = new CarroEntity("Sedan",0,2026);

        var resultado = service.atualizar(id, carro);

        assertEquals(resultado.getModelo(), "Gol");

        verify(repository, times(1)).save(any());
    }

    @Test
    @DisplayName("Deve dar erro ao tentar Atualizar um carro inexistente")
    void carroInexistente() {
        Long id = 1L;
        var carro = new CarroEntity("Sedan",100.00,2026);

        when(repository.findById(any())).thenReturn(Optional.empty());

        var erro = catchThrowable(() -> service.atualizar(id, carro));

        assertThat(erro).isInstanceOf(EntityNotFoundException.class);

        verify(repository, never()).save(any());
    }

    @Test
    @DisplayName("Deve dar erro ao tentar deletar um carro inexistente")
    void deletarCarroInexistente() {
        Long id = 1L;
        when(repository.findById(any())).thenReturn(Optional.empty());

        var erro = catchThrowable(() -> service.deletar(id));

        assertThat(erro).isInstanceOf(EntityNotFoundException.class);

        verify(repository, never()).delete(any());
    }

    @Test
    @DisplayName("Deve deletar um carro existente")
    void deletarCarroComSucesso() {
        Long id = 1L;
        var carro = new CarroEntity("Sedan",100.00,2026);

        when(repository.findById(any())).thenReturn(Optional.of(carro));

        service.deletar(id);

        verify(repository, times(1)).delete(carro);
    }

    @Test
    @DisplayName("Deve buscar carro por ID")
    void buscarPorId() {
        Long id = 1L;
        var carro = new CarroEntity("Sedan",100.00,2026);

        when(repository.findById(any())).thenReturn(Optional.of(carro));

        var carroEncontrado = service.buscarPorId(id);
        assertThat(carroEncontrado.getModelo()).isEqualTo("Sedan");
        assertThat(carroEncontrado.getValorDiario()).isEqualTo(100.00);
        assertThat(carroEncontrado.getAno()).isEqualTo(2026);
    }

    @Test
    @DisplayName("Deve retornar uma lista de carros!")
    void listarTodos() {
        var carro = new CarroEntity(1L, "Sedan",100.00,2026);
        var carro1 = new CarroEntity(2L, "Gol",80.00,2024);

        var lista = List.of(carro, carro1);
        when(repository.findAll()).thenReturn(lista);

        List<CarroEntity> resultado = service.listarTodos();

        assertThat(resultado).hasSize(2);

        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);

    }

}