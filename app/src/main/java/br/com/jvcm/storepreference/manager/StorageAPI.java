package br.com.jvcm.storepreference.manager;

import java.util.Map;

import br.com.jvcm.storepreference.dto.ClientDTO;

public interface StorageAPI {
    String EMPTY_STRING = "";

    @Deprecated
    void salveName(String name);

    @Deprecated
    String restoreName();

    @Deprecated
    void salveAge(int age);

    @Deprecated
    int restoreAge();

    @Deprecated
    void saveBornDate(String bornDate);

    @Deprecated
    String restoreBornDate();

    @Deprecated
    void saveCity(String city);

    @Deprecated
    String restoreCity();

    @Deprecated
    void saveFederationUnit(String federationUnit);

    @Deprecated
    String restoreFedarationUnit();

    @Deprecated
    void saveadress(String adress);

    @Deprecated
    String restoreAdress();

    @Deprecated
    void saveRegister(ClientDTO clientDTO);

    @Deprecated
    ClientDTO restoreClient();


    void saveClientComposite(ClientsModel model);


    ClientsModel restoreClientModel();

}
