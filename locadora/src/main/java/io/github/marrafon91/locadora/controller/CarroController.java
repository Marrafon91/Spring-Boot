package io.github.marrafon91.locadora.controller;

import io.github.marrafon91.locadora.entity.CarroEntity;
import io.github.marrafon91.locadora.model.exception.EntityNotFoundException;
import io.github.marrafon91.locadora.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
@RequiredArgsConstructor
public class CarroController {

    private final CarroService service;


    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody CarroEntity carro) {
        try {
           var carroSalvo = service.salvar(carro);
           return ResponseEntity.status(HttpStatus.CREATED).body(carroSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus
                    .UNPROCESSABLE_ENTITY)
                    .body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<CarroEntity> DetalhesCarro(@PathVariable("id") Long id) {
        try {
            var carroEncontrado = service.buscarPorId(id);
            return ResponseEntity.ok(carroEncontrado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CarroEntity>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id,
                                          @RequestBody CarroEntity carroAtualizado) {
        try {
            service.atualizar(id, carroAtualizado);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
