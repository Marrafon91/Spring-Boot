package io.github.marrafon91.uri;

import io.github.marrafon91.uri.dto.EmpregadoDepDTO;
import io.github.marrafon91.uri.projection.EmpregadoDeptProjection;
import io.github.marrafon91.uri.repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UriApplication2990 implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UriApplication2990.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<EmpregadoDeptProjection> list1 = repository.search1();
		List<EmpregadoDepDTO> result1 = list1.stream().map(EmpregadoDepDTO::new).toList();

		System.out.println("\n");
		System.out.println("*** RESULTADO SQL RAIZ NOT IN: \n");
		for (EmpregadoDepDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n");

		List<EmpregadoDepDTO> result2 = repository.search2();

		System.out.println("\n");
		System.out.println("*** RESULTADO JPQL: \n");
		for (EmpregadoDepDTO obj : result2) {
			System.out.println(obj);
		}
		System.out.println("\n");

		List<EmpregadoDeptProjection> list3 = repository.search3();
		List<EmpregadoDepDTO> result3 = list3.stream().map(EmpregadoDepDTO::new).toList();

		System.out.println("\n");
		System.out.println("*** RESULTADO SQL RAIZ LEFT JOIN: \n");
		for (EmpregadoDepDTO obj : result3) {
			System.out.println(obj);
		}
		System.out.println("\n");
	}
}
