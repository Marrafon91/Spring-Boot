package io.github.marrfon91.JPA_SQL_JPQL.controllers;

import io.github.marrfon91.JPA_SQL_JPQL.dto.PersonDepartmentDTO;
import io.github.marrfon91.JPA_SQL_JPQL.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/people")
public class PersonController implements GenericController {

    @Autowired
    PersonService service;

    @PostMapping
    public ResponseEntity<PersonDepartmentDTO> insert(@RequestBody PersonDepartmentDTO dto) {
        dto = service.insert(dto);
        URI uri = genericHeaderLocation(dto.id());
        return ResponseEntity.created(uri).body(dto);
    }

}
