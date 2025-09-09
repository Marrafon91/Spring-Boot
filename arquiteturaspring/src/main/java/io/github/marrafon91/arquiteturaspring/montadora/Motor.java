package io.github.marrafon91.arquiteturaspring.montadora;

public class Motor {
    private String modelo;
    private String cavalos;
    private Integer cilindros;
    private Double litragem;
    private TipoMotor tipo;

    public String getModelo() {
        return modelo;
    }

    public String getCavalos() {
        return cavalos;
    }

    public Integer getCilindros() {
        return cilindros;
    }

    public Double getLitragem() {
        return litragem;
    }

    public TipoMotor getTipo() {
        return tipo;
    }
}
