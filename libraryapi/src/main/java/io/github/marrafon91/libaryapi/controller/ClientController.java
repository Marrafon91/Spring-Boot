package io.github.marrafon91.libaryapi.controller;

import io.github.marrafon91.libaryapi.model.Client;
import io.github.marrafon91.libaryapi.repository.ClientRepository;
import io.github.marrafon91.libaryapi.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;
    private final ClientRepository repository;

    @PostMapping
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<Void> salvar(@RequestBody @Valid Client client) {
        Client salvar = service.salvar(client);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salvar.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('GERENTE', 'OPERADOR')")
    public ResponseEntity<List<Client>> buscarTodosClients() {
        List<Client> clients = repository.findAll();
        return ResponseEntity.ok(clients);
    }

    @PreAuthorize("hasAnyRole('GERENTE', 'OPERADOR')")
    @GetMapping("{id}")
    public ResponseEntity<Client> obterPorId(@PathVariable("id")UUID id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<Void> deletar(@PathVariable("id") UUID id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<Client> atualizar(
            @PathVariable("id") UUID id,
            @RequestBody @Valid Client client) {

        return repository.findById(id)
                .map(clientAtt -> {
                    clientAtt.setClientId(client.getClientId());
                    clientAtt.setClientSecret(client.getClientSecret());
                    clientAtt.setRedirectURI(client.getRedirectURI());
                    clientAtt.setScope(client.getScope());
                    Client atualizado = service.salvar(clientAtt);
                    return ResponseEntity.ok(atualizado);
                }).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
