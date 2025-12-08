package io.github.marrafon91.uri.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    private Long dnumero;
    private String dnome;

    @OneToMany(mappedBy = "departamento")
    private List<Empregado> empregados = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cpf_gerente")
    private Empregado gerente;

    public Departamento() {
    }

    public Departamento(Long dnumero, String dnome, Empregado gerente) {
        this.dnumero = dnumero;
        this.dnome = dnome;
        this.gerente = gerente;
    }

    public Long getDnumero() {
        return dnumero;
    }

    public void setDnumero(Long dnumero) {
        this.dnumero = dnumero;
    }

    public String getDnome() {
        return dnome;
    }

    public void setDnome(String dnome) {
        this.dnome = dnome;
    }

    public Empregado getGerente() {
        return gerente;
    }

    public void setGerente(Empregado gerente) {
        this.gerente = gerente;
    }

    public List<Empregado> getEmpregados() {
        return empregados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departamento that = (Departamento) o;
        return Objects.equals(dnumero, that.dnumero);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dnumero);
    }
}
