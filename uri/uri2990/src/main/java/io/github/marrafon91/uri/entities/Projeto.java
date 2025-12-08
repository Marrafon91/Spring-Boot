package io.github.marrafon91.uri.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "projetos")
public class Projeto {

    @Id
    private Long pnumero;
    private String pnome;

    @ManyToOne
    @JoinColumn(name = "dnumero")
    private Departamento departamento;

    @ManyToMany(mappedBy = "projetosOndeTrabalha")
    private Set<Empregado> empregados = new HashSet<>();

    public Projeto() {
    }

    public Projeto(Long pnumero, String pnome, Departamento departamento) {
        this.pnumero = pnumero;
        this.pnome = pnome;
        this.departamento = departamento;
    }

    public Long getPnumero() {
        return pnumero;
    }

    public void setPnumero(Long pnumero) {
        this.pnumero = pnumero;
    }

    public String getPnome() {
        return pnome;
    }

    public void setPnome(String pnome) {
        this.pnome = pnome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Set<Empregado> getEmpregados() {
        return empregados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Projeto projeto = (Projeto) o;
        return Objects.equals(pnumero, projeto.pnumero);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pnumero);
    }
}
