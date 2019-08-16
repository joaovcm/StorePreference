package br.com.jvcm.storepreference.manager;

import java.util.HashMap;
import java.util.Map;

import br.com.jvcm.storepreference.dto.ClientDTO;

public class ClientsModel {
    private Map<Integer, ClientDTO> clientMap = new HashMap<>();

    public Map<Integer, ClientDTO> getClientMap() {
        return clientMap;
    }

    public void setClientMap(Map<Integer, ClientDTO> clientMap) {
        this.clientMap = clientMap;
    }
}
