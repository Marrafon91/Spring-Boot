package io.github.marrafon91.locadora.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carro")
@EqualsAndHashCode
@Getter
@Setter
public class CarroEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "valor_diario")
    private double valorDiario;

    @Column(name = "ano")
    private int ano;

    public CarroEntity() {
    }

    public CarroEntity(String modelo, double valorDiario, int ano) {
        this.modelo = modelo;
        this.valorDiario = valorDiario;
        this.ano = ano;
    }

    public CarroEntity(Long id, String modelo, double valorDiario, int ano) {
        this(modelo, valorDiario, ano);
        this.id = id;
    }
}
