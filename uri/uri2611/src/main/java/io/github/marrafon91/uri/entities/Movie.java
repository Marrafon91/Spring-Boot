package io.github.marrafon91.uri.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_genres")
    private Genre genre;

    public Movie() {
    }

    public Movie(Long id, String name, Genre genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
