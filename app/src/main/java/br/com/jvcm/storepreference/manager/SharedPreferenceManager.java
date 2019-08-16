package br.com.jvcm.storepreference.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.Map;

import br.com.jvcm.storepreference.dto.ClientDTO;

public class SharedPreferenceManager implements StorageAPI {

    private SharedPreferences mStorage;

    public SharedPreferenceManager(Context context) {
        mStorage = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Deprecated
    @Override
    public void salveName(String name) {
        mStorage.edit()
                .putString(PreferencesKeys.KEY_NAME.name(), name)
                .apply();
    }

    @Deprecated
    @Override
    public String restoreName() {
        return mStorage.getString(PreferencesKeys.KEY_NAME.name(), EMPTY_STRING);
    }

    @Override
    public void salveAge(int age) {
        mStorage.edit()
                .putInt(PreferencesKeys.KEY_AGE.name(), age)
                .apply();


    }

    @Deprecated
    @Override
    public int restoreAge() {
        return mStorage.getInt(PreferencesKeys.KEY_AGE.name(), 0);
    }

    @Deprecated
    @Override
    public void saveBornDate(String bornDate) {
        mStorage.edit()
                .putString(PreferencesKeys.KEY_BORN_DATE.name(), bornDate)
                .apply();

    }

    @Deprecated
    @Override
    public String restoreBornDate() {
        return mStorage.getString(PreferencesKeys.KEY_BORN_DATE.name(), EMPTY_STRING);
    }

    @Deprecated
    @Override
    public void saveCity(String city) {
        mStorage.edit()
                .putString(PreferencesKeys.KEY_CITY.name(), city)
                .apply();

    }

    @Deprecated
    @Override
    public String restoreCity() {
        return mStorage.getString(PreferencesKeys.KEY_CITY.name(), EMPTY_STRING);
    }

    @Deprecated
    @Override
    public void saveFederationUnit(String federationUnit) {
        mStorage.edit()
                .putString(PreferencesKeys.KEY_FEDERATION_UNIT.name(), federationUnit)
                .apply();

    }

    @Deprecated
    @Override
    public String restoreFedarationUnit() {
        return mStorage.getString(PreferencesKeys.KEY_FEDERATION_UNIT.name(), EMPTY_STRING);
    }

    @Deprecated
    @Override
    public void saveadress(String adress) {
        mStorage.edit()
                .putString(PreferencesKeys.KEY_ADDRESS.name(), adress)
                .apply();

    }

    @Deprecated
    @Override
    public String restoreAdress() {
        return mStorage.getString(PreferencesKeys.KEY_ADDRESS.name(), EMPTY_STRING);
    }

    @Deprecated
    @Override
    public void saveRegister(ClientDTO clientDTO) {
        Gson gson = new Gson();

        mStorage.edit()
                .putString(PreferencesKeys.KEY_CLIENT.name(), gson.toJson(clientDTO))
                .apply();
    }

    @Deprecated
    @Override
    public ClientDTO restoreClient() {
        String json = mStorage.getString(PreferencesKeys.KEY_CLIENT.name(), null);
        return json != null ? new Gson().fromJson(json, ClientDTO.class) : null;
    }

    @Override
    public void saveClientComposite(ClientsModel model) {
        Gson gson = new Gson();
        mStorage.edit()
                .putString(PreferencesKeys.KEY_CLIENT_MODEL.name(), gson.toJson(model))
                .apply();
    }

    @Override
    public ClientsModel restoreClientModel() {
        String json = mStorage.getString(PreferencesKeys.KEY_CLIENT_MODEL.name(), null);
        return json != null ? new Gson().fromJson(json, ClientsModel.class) : null;
    }
}
