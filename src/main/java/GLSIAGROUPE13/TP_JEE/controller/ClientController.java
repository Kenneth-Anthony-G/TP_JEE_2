package GLSIAGROUPE13.TP_JEE.controller;

import GLSIAGROUPE13.TP_JEE.dto.ClientDto;
import GLSIAGROUPE13.TP_JEE.entity.Client;
import GLSIAGROUPE13.TP_JEE.service.ImpService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ega/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public List<ClientDto> showAllClient(){
        return clientService.showAllClient();
    }

    @GetMapping("/{id}")
    public ClientDto getOneClient(@PathVariable int id){
        return clientService.getOneClient(id);
    }

    @PostMapping("/")
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    public void deleteClient(int id){
        clientService.deleteClient(id);
    }



}
