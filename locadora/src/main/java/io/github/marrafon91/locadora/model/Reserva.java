package io.github.marrafon91.locadora.model;

import io.github.marrafon91.locadora.model.exceptions.ReservaInvalidaException;

public class Reserva {
    private Carro carro;
    private Cliente cliente;
    private Integer quantidadeDias;

    public Reserva() {
    }

    public Reserva(Carro carro, Cliente cliente, Integer quantidadeDias) {
        if (quantidadeDias < 1) {
            throw new ReservaInvalidaException("Quantidade de dias inválida");
        }
        this.carro = carro;
        this.cliente = cliente;
        this.quantidadeDias = quantidadeDias;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(Integer quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public double calcularTotal() {
        return this.carro.calcularValorAluguel(this.quantidadeDias);
    }

}
