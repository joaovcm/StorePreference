package br.com.jvcm.storepreference.query;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.jvcm.storepreference.R;
import br.com.jvcm.storepreference.query.adapter.ClientAdapter;
import br.com.jvcm.storepreference.core.ClientComposite;
import br.com.jvcm.storepreference.dto.ClientsModel;
import br.com.jvcm.storepreference.core.StorageAPI;

public class ListClientFragment extends Fragment {


    public static ListClientFragment newInstance() {
        ListClientFragment fragment = new ListClientFragment();
        return fragment;
    }

    private RecyclerView mRecyclerView;
    private List<ClientsModel> mClientModel = new ArrayList<>();
    private ClientAdapter mClientAdapter;
    private ClientComposite mComposite;
    private StorageAPI mStorage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container , true);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mClientAdapter);
        mComposite = new ClientComposite(mStorage);
        mClientAdapter = new ClientAdapter(mClientModel);

        return rootView;
    }
}
