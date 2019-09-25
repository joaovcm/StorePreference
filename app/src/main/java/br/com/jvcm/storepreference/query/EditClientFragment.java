package br.com.jvcm.storepreference.query;

import android.content.ClipData;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import br.com.jvcm.storepreference.R;
import br.com.jvcm.storepreference.core.ClientComposite;
import br.com.jvcm.storepreference.core.SharedPreferenceManager;
import br.com.jvcm.storepreference.core.StorageAPI;
import br.com.jvcm.storepreference.dto.ClientDTO;

public class EditClientFragment extends Fragment {

    private static String KEY_BUNDLE = "CLIENT";

    public static EditClientFragment newInstance(ClientDTO item) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_BUNDLE, new Gson().toJson(item));
        EditClientFragment fragment = new EditClientFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private ClientDTO clientDTO;
    private ClientComposite mComposite;

    private EditText Name;
    private EditText Age;
    private EditText BornDate;
    private EditText Adress;
    private EditText UnitFederation;
    private EditText City;
    private Button btnEditClient;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = (inflater.inflate(R.layout.fragment_edit_client, null));
        clientDTO = new Gson().fromJson(getArguments().getString(KEY_BUNDLE), ClientDTO.class);
        //todo nome de objetos devem common case
        Name = rootView.findViewById(R.id.edt_edit_name);
        Age = rootView.findViewById(R.id.edt_edit_age);
        BornDate = rootView.findViewById(R.id.edt_edit_adressborn_date);
        Adress = rootView.findViewById(R.id.edt_edit_adress);
        UnitFederation = rootView.findViewById(R.id.edt_edit_utf);
        City = rootView.findViewById(R.id.edt_edit_city);
        btnEditClient = rootView.findViewById(R.id.btn_edit);
        mComposite = new ClientComposite( new SharedPreferenceManager(getContext()));

        btnEditClient.setOnClickListener(this::onEditClick);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateForm();
    }

    private void populateForm() {
        Name.setText(clientDTO.getName());
        Age.setText(String.valueOf(clientDTO.getAge()));
        BornDate.setText(clientDTO.getBornData());
        Adress.setText(clientDTO.getAddress());
        UnitFederation.setText(clientDTO.getFederationUnit());
        City.setText(clientDTO.getCity());
    }

    public void  onEditClick(View view) {
        ClientDTO clientEdit = new ClientDTO();
        clientEdit.setId(clientDTO.getId());
        clientEdit.setName(Name.getText().toString());clientEdit.setBornData(BornDate.getText().toString());
        clientEdit.setFederationUnit(UnitFederation.getText().toString());
        clientEdit.setCity(City.getText().toString());
        clientEdit.setAge(Integer.parseInt(Age.getText().toString()));
        clientEdit.setAddress(Adress.getText().toString());
        mComposite.editClient(clientDTO.getId(), clientEdit);
        getFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, new ListClientFragment()).
                commit();

    }



}
