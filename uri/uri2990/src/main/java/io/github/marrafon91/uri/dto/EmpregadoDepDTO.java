package io.github.marrafon91.uri.dto;

import io.github.marrafon91.uri.projection.EmpregadoDeptProjection;

public record EmpregadoDepDTO(String cpf, String enome, String dnome) {

    public EmpregadoDepDTO {
    }

    public EmpregadoDepDTO(EmpregadoDeptProjection projection) {
        this (
                projection.getCpf(),
                projection.getEnome(),
                projection.getDnome()
        );
    }

    @Override
    public String toString() {
        return "EmpregadoDepDTO{" +
                "cpf='" + cpf + '\'' +
                ", enome='" + enome + '\'' +
                ", dnome='" + dnome + '\'' +
                '}';
    }
}
