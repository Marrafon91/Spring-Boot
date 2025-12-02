package io.github.marrafon91.uri;

import io.github.marrafon91.uri.dto.CustomerMinDTO;
import io.github.marrafon91.uri.projections.CustomerMinProjection;
import io.github.marrafon91.uri.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UriApplication2602 implements CommandLineRunner {

	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UriApplication2602.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CustomerMinProjection> list = repository.search1("rs");
		List<CustomerMinDTO> result1 = list.stream().map(CustomerMinDTO::new).toList();

		System.out.println("Resultado SQL RAIZ:");
		for (CustomerMinDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n\n");

		List<CustomerMinDTO> result2 = repository.search2("rs");

		System.out.println("Resultado JPQL");
		for (CustomerMinDTO obj : result2) {
			System.out.println(obj);
		}

	}
}
