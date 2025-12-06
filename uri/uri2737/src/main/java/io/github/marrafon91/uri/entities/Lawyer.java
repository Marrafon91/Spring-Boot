package io.github.marrafon91.uri.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lawyers")
public class Lawyer {

    @Id
    private Long id;
    private String name;
    private Integer customersNumber;

    public Lawyer() {
    }

    public Lawyer(Long id, String name, Integer customersNumber) {
        this.id = id;
        this.name = name;
        this.customersNumber = customersNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCustomersNumber() {
        return customersNumber;
    }

    public void setCustomersNumber(Integer customersNumber) {
        this.customersNumber = customersNumber;
    }
}
