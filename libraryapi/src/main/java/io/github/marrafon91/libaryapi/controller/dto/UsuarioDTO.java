package io.github.marrafon91.libaryapi.controller.dto;

import java.util.List;

public record UsuarioDTO(String login, String senha, List<String> roles) {
}
