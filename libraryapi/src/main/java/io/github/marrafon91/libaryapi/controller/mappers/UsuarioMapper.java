package io.github.marrafon91.libaryapi.controller.mappers;

import io.github.marrafon91.libaryapi.controller.dto.UsuarioDTO;
import io.github.marrafon91.libaryapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
}
