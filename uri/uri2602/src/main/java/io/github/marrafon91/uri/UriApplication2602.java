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

		List<CustomerMinProjection> list = repository.search1("RS");
		List<CustomerMinDTO> result1 = list.stream().map(CustomerMinDTO::new).toList();

		for (CustomerMinDTO obj : result1) {
			System.out.println(obj);
		}
	}
}
