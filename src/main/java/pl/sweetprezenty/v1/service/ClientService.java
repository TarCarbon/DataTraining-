package pl.sweetprezenty.v1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sweetprezenty.v1.entity.Client;
import pl.sweetprezenty.v1.repository.ClientRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}

