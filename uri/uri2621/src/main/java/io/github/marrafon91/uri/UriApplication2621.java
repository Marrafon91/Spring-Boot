package io.github.marrafon91.uri;

import io.github.marrafon91.uri.dto.ProductMinDTO;
import io.github.marrafon91.uri.projection.ProductMinProjection;
import io.github.marrafon91.uri.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UriApplication2621 implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UriApplication2621.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<ProductMinProjection> list = repository.search1(10, 20, "P");
		List<ProductMinDTO> result1 = list.stream().map(ProductMinDTO::new).toList();

		System.out.println("\n *** RESULTADO SQL RAIZ");
		for (ProductMinDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n");

		List<ProductMinDTO> result2 = repository.search2(10, 20, "P");

		System.out.println("\n *** RESULTADO JPQL");
		for (ProductMinDTO obj : result2) {
			System.out.println(obj);
		}
	}
}
