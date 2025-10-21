package io.github.marrafon91.libaryapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
        title = "Library-api",
        version = "V1",
        contact = @Contact(
                name = "Guilherme Marrafon",
                email = "guilherme.marrafon@libraryapi.com",
                url = "libraryapi.com"
        )
))
public class OpenApiConfiguration {

}
