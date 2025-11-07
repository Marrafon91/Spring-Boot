package io.github.marrafon91.locadora.model;

public class Carro {
    private String modelo;
    private Double valorDiario;

    public Carro() {
    }

    public Carro(String modelo, Double valorDiario) {
        this.modelo = modelo;
        this.valorDiario = valorDiario;
    }

    public Double calcularValorAluguel(int dias) {
        return dias * valorDiario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(Double valorDiario) {
        this.valorDiario = valorDiario;
    }
}
