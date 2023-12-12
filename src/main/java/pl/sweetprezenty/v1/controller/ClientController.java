package pl.sweetprezenty.v1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sweetprezenty.v1.dto.ClientDto;
import pl.sweetprezenty.v1.modify.ModifyResponse;
import pl.sweetprezenty.v1.service.ClientService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/list")
    public List<ClientDto> list() {
        return ClientDto.from(clientService.findAll());
    }

    @PostMapping("/create")
    public ModifyResponse create(@RequestBody ClientDto dto) {
        if (clientService.isValid(dto.getName())) {
            return ModifyResponse.failed("name can`t be null or empty");
        }

        if (clientService.isValid(dto.getSurname())) {
            return ModifyResponse.failed("surname can`t be null or empty");
        }

        if (clientService.isValid(dto.getEmail())) {
            return ModifyResponse.failed("email can`t be null or empty");
        }

        if (clientService.isValidEmail(dto)) {
            return ModifyResponse.failed("bed email format");
        }
        clientService.create(dto);
        return ModifyResponse.success("create successful");
    }

    @PostMapping("/update")
    public ModifyResponse update(@RequestBody ClientDto dto) {
        if (clientService.isValid(dto.getName())) {
            return ModifyResponse.failed("name can`t be null or empty");
        }

        if (clientService.isValid(dto.getSurname())) {
            return ModifyResponse.failed("surname can`t be null or empty");
        }

        if (clientService.isValid(dto.getEmail())) {
            return ModifyResponse.failed("email can`t be null or empty");
        }

        if (clientService.isValidEmail(dto)) {
            return ModifyResponse.failed("bed email format");
        }

        if (clientService.exist(dto.getId())) {
            clientService.update(dto);
            return ModifyResponse.success("Client is update");
        } else {
            return ModifyResponse.failed("client with id " + dto.getId() + " not exist");
        }
    }

    @GetMapping("/exist")
    public ModifyResponse getExist(Long id) {
        return ModifyResponse.builder()
                .success(clientService.exist(id)).message("Client with id=" + id + " is " + clientService.exist(id)).build();
    }

}
