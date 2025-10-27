package io.github.marrafon91.libaryapi.service;

import io.github.marrafon91.libaryapi.model.Client;
import io.github.marrafon91.libaryapi.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository repository;
    private final PasswordEncoder encoder;

    public Client salvar(Client client) {
        log.info("clientSecret recebido: {}", client.getClientSecret());
        log.info("Tipo real de clientSecret: {}", client.getClientSecret().getClass().getName());
        var senhaCriptografada = encoder.encode(client.getClientSecret());
        client.setClientSecret(senhaCriptografada);
        return repository.save(client);
    }

    public Client obterPorClientId(String clientId) {
        return repository.findByClientId(clientId);
    }
}
