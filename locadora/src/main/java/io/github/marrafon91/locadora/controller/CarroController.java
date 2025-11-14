package io.github.marrafon91.locadora.controller;

import io.github.marrafon91.locadora.entity.CarroEntity;
import io.github.marrafon91.locadora.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
