package io.github.marrafon91.uri;

import io.github.marrafon91.uri.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UriApplication2611 implements CommandLineRunner {

	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UriApplication2611.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
