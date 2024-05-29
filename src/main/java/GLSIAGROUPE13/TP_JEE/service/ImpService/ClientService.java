package GLSIAGROUPE13.TP_JEE.service.ImpService;

import GLSIAGROUPE13.TP_JEE.dto.ClientDto;
import GLSIAGROUPE13.TP_JEE.entity.Client;
import GLSIAGROUPE13.TP_JEE.repository.ClientRepository;
import GLSIAGROUPE13.TP_JEE.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public ClientDto getOneClient(int id) {
        return ClientDto.convertToDto(clientRepository.getOne(id)) ;
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.deleteById(id);

    }

    @Override
    public List<ClientDto> showAllClient() {
        return clientRepository.findAll().stream().map(ClientDto::convertToDto).collect(Collectors.toList());
    }
}
