package br.com.jvcm.storepreference.manager;

import java.util.ArrayList;
import java.util.List;

import br.com.jvcm.storepreference.dto.ClientDTO;

public class ClientComposite {
    private StorageAPI mStorage;
    private ClientsModel model; //mapa de clients

    public ClientComposite(StorageAPI storageAPI) {
        mStorage = storageAPI;

        model = mStorage.restoreClientModel();
        if (model == null) {
            model = new ClientsModel();
        }
    }

    //Esse metodo adiciona um novo client
    public void addClient(ClientDTO clientDTO) {
        clientDTO.setId(model.getClientMap().size() + 1);
        model.getClientMap().put(clientDTO.getId(), clientDTO);
        mStorage.saveClientComposite(model);
    }

    //Esse metodo devolve a lista de cliente
    public List<ClientDTO> getAllClients() {
        return new ArrayList(model.getClientMap().values());
    }

    public ClientDTO getClient(Integer id) {
        return model.getClientMap().containsKey(id) ? model.getClientMap().get(id) : null;
    }

    //Esse metodo edita um cliente especifico por id
    public void editClient(Integer id, ClientDTO clientDTO) {
        model.getClientMap().get(id).setName(clientDTO.getName());
        model.getClientMap().get(id).setAge(clientDTO.getAge());
        model.getClientMap().get(id).setCity(clientDTO.getCity());
        model.getClientMap().get(id).setAddress(clientDTO.getAddress());
        model.getClientMap().get(id).setFederationUnit(clientDTO.getFederationUnit());
        model.getClientMap().get(id).setBornData(clientDTO.getBornData());
        mStorage.saveClientComposite(model);
    }
}
