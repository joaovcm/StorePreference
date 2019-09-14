package br.com.jvcm.storepreference.query;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import br.com.jvcm.storepreference.R;
import br.com.jvcm.storepreference.core.ClientComposite;
import br.com.jvcm.storepreference.dto.ClientDTO;

public class EditClientFragment extends Fragment {

    private static String KEY_BUNDLE = "CLIENT";

    public static EditClientFragment newInstance(ClientDTO item) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_BUNDLE, new Gson().toJson(item));
        EditClientFragment fragment = new EditClientFragment();
        fragment.getArguments().putAll(bundle);
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
    private Button EditClient;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = (inflater.inflate(R.layout.fragment_edit_client, null));

        clientDTO = new Gson().fromJson(getArguments().getString(KEY_BUNDLE), ClientDTO.class);
        Name = rootView.findViewById(R.id.edt_edit_name);
        Age = rootView.findViewById(R.id.edt_edit_age);
        BornDate = rootView.findViewById(R.id.edt_edit_adressborn_date);
        Adress = rootView.findViewById(R.id.edt_edit_adress);
        UnitFederation = rootView.findViewById(R.id.edt_edit_utf);
        City = rootView.findViewById(R.id.edt_edit_city);
        EditClient = rootView.findViewById(R.id.btn_edit);
        //EditClient.setOnClickListener(this::onEditClick);

        return rootView;
    }

    private void populateForm() {
        Name.setText(clientDTO.getName());
        Age.setText(clientDTO.getAge());
        BornDate.setText(clientDTO.getBornData());
        Adress.setText(clientDTO.getAddress());
        UnitFederation.setText(clientDTO.getFederationUnit());
        City.setText(clientDTO.getCity());


    }

    public void onEditClick() {
        mComposite.editClient(clientDTO.getId(), clientDTO);
    }

}
