package io.github.marrafon91.locadora.controller;

import io.github.marrafon91.locadora.entity.CarroEntity;
import io.github.marrafon91.locadora.model.exception.EntityNotFoundException;
import io.github.marrafon91.locadora.service.CarroService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CarroController.class)
class CarroControllerTest {

    @Autowired
    MockMvc mvc;

    @MockitoBean
    CarroService carroService;

    @Test
    void salvarCarro() throws  Exception {
        CarroEntity carro = new CarroEntity(1L,"Honda Civic", 150.00, 2027);

        when(carroService.salvar(Mockito.any())).thenReturn(carro);

        String json = """
                {
                  "modelo": "Honda Civic",
                  "valorDiario": 150.00,
                  "ano": 2027
                }
                """;

        //Execução
        ResultActions result = mvc.perform(
                post("/carros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        );

        //Verificação
        result
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.modelo").value("Honda Civic"));
    }

    @Test
    void deveObterDetalhesCarro() throws Exception {
        when(carroService.buscarPorId(Mockito.any())).thenReturn(new CarroEntity(
                1L, "Civic", 250, 2028
        ));

        mvc.perform(
                get("/carros/1")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.modelo").value("Civic"))
                .andExpect(jsonPath("$.valorDiario").value(250.0))
                .andExpect(jsonPath("$.ano").value(2028));
    }

    @Test
    void deveRetornarNotFoundCarroInexistente() throws Exception {
        when(carroService.buscarPorId(Mockito.any())).thenThrow(EntityNotFoundException.class);
        mvc.perform(
                get("/carros/1")
        ).andExpect(status().isNotFound());
    }

    @Test
    void deveListarCarros() throws Exception {
        var listagem = List.of(
                new CarroEntity(1L, "Argo", 150, 2025),
                new CarroEntity(2L, "Celta", 80.0, 2015),
                new CarroEntity(3L, "Renault", 100.0, 2018)
        );
        when(carroService.listarTodos()).thenReturn(listagem);

        mvc.perform(
                get("/carros")
        )
         .andExpect(status().isOk())
         .andExpect(jsonPath("$.[0].modelo").value("Argo"))
         .andExpect(jsonPath("$.[1].modelo").value("Celta"))
         .andExpect(jsonPath("$.[2].modelo").value("Renault"));
    }
}