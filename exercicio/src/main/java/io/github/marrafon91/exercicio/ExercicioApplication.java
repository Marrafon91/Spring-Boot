package io.github.marrafon91.exercicio;

import io.github.marrafon91.exercicio.entities.Order;
import io.github.marrafon91.exercicio.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication

public class ExercicioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExercicioApplication.class, args);
	}

	@Autowired
	private OrderService orderService;

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o codigo do produto: ");
		int code = sc.nextInt();

		System.out.print("Digite o valor do pedido: ");
		double basic = sc.nextDouble();

		System.out.print("Disconto: ");
		double discount = sc.nextDouble();

		Order order = new Order(code,basic,discount);

		double total = orderService.total(order);

		System.out.println("Pedido código: " + code);
		System.out.printf("Valor total: %.2f%n ", total);

		sc.close();
	}
}
