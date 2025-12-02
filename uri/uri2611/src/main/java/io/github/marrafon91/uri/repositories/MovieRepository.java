package io.github.marrafon91.uri.repositories;

import io.github.marrafon91.uri.dto.MovieMinDTO;
import io.github.marrafon91.uri.entities.Movie;
import io.github.marrafon91.uri.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name "
            + "FROM movies "
            + "INNER JOIN genres ON movies.id_genres = genres.id "
            + "WHERE genres.description = :genreName ")
    List<MovieMinProjection> search1(String genreName);

    @Query("SELECT new io.github.marrafon91.uri.dto.MovieMinDTO(obj.id, obj.name) "
            + "FROM Movie obj "
            + "WHERE obj.genre.description = :genreName ")
    List<MovieMinDTO> search2(String genreName);
}
