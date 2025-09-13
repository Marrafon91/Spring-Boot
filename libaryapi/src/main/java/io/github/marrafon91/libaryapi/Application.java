package io.github.marrafon91.libaryapi;

import io.github.marrafon91.libaryapi.model.Autor;
import io.github.marrafon91.libaryapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);
		AutorRepository repository = context.getBean(AutorRepository.class);

		exemploSalvarResgistro(repository);
	}

	public static void exemploSalvarResgistro(AutorRepository autorRepository) {
		Autor autor = new Autor();
		autor.setName("Jose");
		autor.setNacionalidade("Brasileiro");
		autor.setDataNascimento(LocalDate.of(1950, 1, 31));

		var autorSalvo = autorRepository.save(autor);
		System.out.println("Autor Salvo: " + autorSalvo);
	}
}
