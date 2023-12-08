package pl.sweetprezenty.v1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sweetprezenty.v1.dto.ClientDto;
import pl.sweetprezenty.v1.service.ClientService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("list")
    public List<ClientDto> list() {
        return ClientDto.from(clientService.findAll());
    }
}
