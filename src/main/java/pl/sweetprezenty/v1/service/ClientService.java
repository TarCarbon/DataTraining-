package pl.sweetprezenty.v1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sweetprezenty.v1.entity.Client;
import pl.sweetprezenty.v1.repository.ClientRepository;
import pl.sweetprezenty.v1.dto.ClientDto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void create(ClientDto dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setSurname(dto.getSurname());
        client.setEmail(dto.getEmail());
        clientRepository.save(client);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }

    public void update(ClientDto dto) {
        Client client = clientRepository.findById(dto.getId()).orElseThrow();
        client.setName(dto.getName());
        client.setSurname(dto.getSurname());
        client.setEmail(dto.getEmail());
        clientRepository.save(client);
    }

    public boolean exist(Long id) {
        return clientRepository.existsById(id);
    }


    public boolean isValid(String param) {

        return param == null && param.isBlank();
    }
    public boolean isValidEmail(ClientDto dto) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(dto.getEmail());
        return !matcher.matches();
    }

}