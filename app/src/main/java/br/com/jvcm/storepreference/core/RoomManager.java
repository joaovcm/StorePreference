package br.com.jvcm.storepreference.core;

import br.com.jvcm.storepreference.dto.ClientDTO;
import br.com.jvcm.storepreference.dto.ClientsModel;

public class RoomManager implements StorageAPI {
    @Override
    public void salveName(String name) {

    }

    @Override
    public String restoreName() {
        return null;
    }

    @Override
    public void salveAge(int age) {

    }

    @Override
    public int restoreAge() {
        return 0;
    }

    @Override
    public void saveBornDate(String bornDate) {

    }

    @Override
    public String restoreBornDate() {
        return null;
    }

    @Override
    public void saveCity(String city) {

    }

    @Override
    public String restoreCity() {
        return null;
    }

    @Override
    public void saveFederationUnit(String federationUnit) {

    }

    @Override
    public String restoreFedarationUnit() {
        return null;
    }

    @Override
    public void saveadress(String adress) {

    }

    @Override
    public String restoreAdress() {
        return null;
    }

    @Override
    public void saveRegister(ClientDTO clientDTO) {

    }

    @Override
    public ClientDTO restoreClient() {
        return null;
    }

    @Override
    public void saveClientComposite(ClientsModel model) {

    }

    @Override
    public ClientsModel restoreClientModel() {
        return null;
    }
}
