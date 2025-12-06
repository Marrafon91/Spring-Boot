package io.github.marrafon91.uri;

import io.github.marrafon91.uri.dto.LawyerMinDTO;
import io.github.marrafon91.uri.projection.LawyerMinProjection;
import io.github.marrafon91.uri.repository.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UriApplication2737 implements CommandLineRunner {

	@Autowired
	LawyerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UriApplication2737.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<LawyerMinProjection> list = repository.search1();
		List<LawyerMinDTO> result1 = list.stream().map(LawyerMinDTO::new).toList();

		System.out.println("\n");
		System.out.println("*** SQL RAIZ: ");
		for (LawyerMinDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n");
	}
}
