package io.github.marrafon91.uri;

import io.github.marrafon91.uri.dto.CategorySumDTO;
import io.github.marrafon91.uri.projection.CategorySumProjection;
import io.github.marrafon91.uri.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UriApplication2609 implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UriApplication2609.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CategorySumProjection> list = repository.search1();
		List<CategorySumDTO> result1 = list.stream().map(CategorySumDTO::new).toList();

		System.out.println("\n");
		System.out.println("*** RESULTADO SQL RAIZ: ");
		for (CategorySumDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n");

		List<CategorySumDTO> result2 = repository.search2();

		System.out.println("\n");
		System.out.println("*** RESULTADO JPQL: ");
		for (CategorySumDTO obj : result2) {
			System.out.println(obj);
		}
		System.out.println("\n");
	}
}
