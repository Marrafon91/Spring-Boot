package io.github.marrafon91.uri.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private Long id;
    private String name;
    private Integer amount;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_categories")
    private Category categories;

    public Product() {
    }

    public Product(Long id, String name, Integer amount, Double price, Category categories) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.categories = categories;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }
}
