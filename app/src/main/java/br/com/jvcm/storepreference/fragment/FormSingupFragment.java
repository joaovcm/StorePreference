package br.com.jvcm.storepreference.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.com.jvcm.storepreference.R;
import br.com.jvcm.storepreference.activity.ClientManagerActivity;
import br.com.jvcm.storepreference.dto.ClientDTO;
import br.com.jvcm.storepreference.manager.ClientComposite;
import br.com.jvcm.storepreference.manager.StorageAPI;

public class FormSingupFragment extends Fragment {
    private ClientComposite mComposite;

    //todo boolean, salvar ou editar
    public static FormSingupFragment newInstance() {

        FormSingupFragment fragment = new FormSingupFragment();
        return fragment;
    }


    private EditText name;
    private EditText age;
    private EditText bornDate;
    private EditText adress;
    private EditText city;
    private EditText federationUnit;
    private Button save;
    private StorageAPI mStorage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_form_singup, null);

        mStorage = ((ClientManagerActivity) getActivity()).getStorage();
        mComposite = new ClientComposite(mStorage);
        name = rootView.findViewById(R.id.edt_name);
        age = rootView.findViewById(R.id.edt_age);
        bornDate = rootView.findViewById(R.id.edt_born_date);
        adress = rootView.findViewById(R.id.edt_adress);
        city = rootView.findViewById(R.id.edt_city);
        federationUnit = rootView.findViewById(R.id.edt_utf);
        save = rootView.findViewById(R.id.btn_save);
        save.setOnClickListener(this::onClick);
        restoreValues();

        return rootView;
    }

    private void restoreValues() {
        ClientDTO clientDTO = mComposite.getClient(1);
        if (clientDTO != null) {
            name.setText(clientDTO.getName());
            age.setText(String.valueOf(clientDTO.getAge()));
            bornDate.setText(clientDTO.getBornData());
            adress.setText(clientDTO.getAddress());
            city.setText(clientDTO.getCity());
            federationUnit.setText(clientDTO.getFederationUnit());
        }

    }

    private void onClick(View view) {
        ClientDTO client = new ClientDTO();
        client.setName(name.getText().toString());
        client.setAge(Integer.parseInt(age.getText().toString()));
        client.setBornData(bornDate.getText().toString());
        client.setAddress(adress.getText().toString());
        client.setCity(city.getText().toString());
        client.setFederationUnit(federationUnit.getText().toString());
        mComposite.addClient(client);
    }

    //todo onClick salve, getStorage
}
