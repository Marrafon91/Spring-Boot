package io.github.marrafon91.uri.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "empregados")
public class Empregado {

    @Id
    private String cpf;
    private String enome;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "cpf_supervisor")
    private Empregado supervisor;

    @OneToMany(mappedBy = "supervisor")
    private List<Empregado> supervisionados = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "trabalha",
     joinColumns = @JoinColumn(name = "cpf_emp"),
     inverseJoinColumns = @JoinColumn(name = "pnumero"))
    private Set<Projeto> projetosOndeTrabalha = new HashSet<>();

    public Empregado() {
    }

    public Empregado(String cpf, String enome, Double salary, Empregado supervisor) {
        this.cpf = cpf;
        this.enome = enome;
        this.salary = salary;
        this.supervisor = supervisor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnome() {
        return enome;
    }

    public void setEnome(String enome) {
        this.enome = enome;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Empregado getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Empregado supervisor) {
        this.supervisor = supervisor;
    }

    public List<Empregado> getSupervisionados() {
        return supervisionados;
    }

    public Set<Projeto> getProjetosOndeTrabalha() {
        return projetosOndeTrabalha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empregado empregado = (Empregado) o;
        return Objects.equals(cpf, empregado.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
