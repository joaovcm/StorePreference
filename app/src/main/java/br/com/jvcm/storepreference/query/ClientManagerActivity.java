package br.com.jvcm.storepreference.query;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.jvcm.storepreference.R;
import br.com.jvcm.storepreference.core.SharedPreferenceManager;
import br.com.jvcm.storepreference.core.StorageAPI;

public class ClientManagerActivity extends AppCompatActivity {

    //todo implementa Storage
    private StorageAPI mStorage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_manager_activity);

        mStorage = new SharedPreferenceManager(getApplicationContext());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, ListClientFragment.newInstance())
                .commit();
    }

    //todo get Storage

    public StorageAPI getStorage(){
        return mStorage;
    }

}
