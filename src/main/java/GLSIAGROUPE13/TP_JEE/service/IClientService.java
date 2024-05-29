package GLSIAGROUPE13.TP_JEE.service;

import GLSIAGROUPE13.TP_JEE.dto.ClientDto;
import GLSIAGROUPE13.TP_JEE.entity.Client;

import java.util.List;

public interface IClientService {

    Client saveClient(Client client);
    public ClientDto getOneClient(int id);
    public void deleteClient(int id);
    public List<ClientDto> showAllClient();

}
