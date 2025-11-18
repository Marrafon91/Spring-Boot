package io.github.marrafon91.Estudos;

import io.github.marrafon91.Estudos.entities.Employee;
import io.github.marrafon91.Estudos.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstudosApplication implements CommandLineRunner {

	@Autowired
	private SalaryService salaryService;

	public static void main(String[] args) {
		SpringApplication.run(EstudosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee("Maria", 4000);
		System.out.println(salaryService.netSalary(employee));
	}
}
