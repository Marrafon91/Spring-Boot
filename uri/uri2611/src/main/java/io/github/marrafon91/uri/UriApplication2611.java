package io.github.marrafon91.uri;

import io.github.marrafon91.uri.dto.MovieMinDTO;
import io.github.marrafon91.uri.projections.MovieMinProjection;
import io.github.marrafon91.uri.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UriApplication2611 implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UriApplication2611.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieMinProjection> list = repository.search1("Action");
		List<MovieMinDTO> result1 = list.stream().map(MovieMinDTO::new).toList();

		System.out.println("\n*** RESULTADO SQL RAIZ");
		for (MovieMinDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n\n");

		List<MovieMinDTO> result2 = repository.search2("Action");

		System.out.println("\n*** RESULTADO JPQL");
		for (MovieMinDTO obj : result2) {
			System.out.println(obj);
		}

	}
}
