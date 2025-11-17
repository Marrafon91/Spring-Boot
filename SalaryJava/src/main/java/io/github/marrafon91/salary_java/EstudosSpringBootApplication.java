package io.github.marrafon91.salary_java;

import io.github.marrafon91.salary_java.entities.Employee;
import io.github.marrafon91.salary_java.services.BrasilTaxService;
import io.github.marrafon91.salary_java.services.PensionService;
import io.github.marrafon91.salary_java.services.SalaryService;
import io.github.marrafon91.salary_java.services.TaxService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class EstudosSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudosSpringBootApplication.class, args);
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome: ");
		String name = sc.nextLine();

		System.out.print("Salario Bruto: ");
		double grossSalary = sc.nextDouble();

		Employee employee = new Employee(name, grossSalary);

		TaxService taxService = new BrasilTaxService();
		PensionService pensionService = new PensionService();

		SalaryService salaryService = new SalaryService(taxService, pensionService);

		double netSalary = salaryService.netSalary(employee);
		System.out.printf("Salario liquido = %.2f%n", netSalary);

		sc.close();
	}

}
