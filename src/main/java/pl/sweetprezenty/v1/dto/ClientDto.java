package pl.sweetprezenty.v1.dto;

import lombok.Builder;
import lombok.Data;
import pl.sweetprezenty.v1.entity.Client;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Builder
@Data
public class ClientDto {
    private String email;
    private String name;
    private String surname;

    public static List<ClientDto> from(Iterable<Client> clients){
        List<ClientDto> clientDtoList = new ArrayList<>();
        for (Client client: clients) {
            clientDtoList.add(from(client));
        }
        return clientDtoList;
    }

    public static ClientDto from(Client client){
        return ClientDto.builder()
                .email(client.getEmail())
                .name(client.getName())
                .surname(client.getSurname())
                .build();
    }
}
