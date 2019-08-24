package br.com.jvcm.storepreference.query;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.jvcm.storepreference.R;
import br.com.jvcm.storepreference.core.ClientComposite;
import br.com.jvcm.storepreference.core.SharedPreferenceManager;
import br.com.jvcm.storepreference.core.StorageAPI;
import br.com.jvcm.storepreference.dto.ClientDTO;
import br.com.jvcm.storepreference.query.adapter.ClientAdapter;

public class ListClientFragment extends Fragment {


    public static ListClientFragment newInstance() {
        ListClientFragment fragment = new ListClientFragment();
        return fragment;
    }

    private RecyclerView mRecyclerView;
    private List<ClientDTO> mDataSet = new ArrayList<>();
    private ClientAdapter mClientAdapter;
    private ClientComposite mComposite;
    private StorageAPI mStorage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, null);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mStorage = new SharedPreferenceManager(getActivity().getApplicationContext());
        mComposite = new ClientComposite(mStorage);
        mDataSet = mComposite.getAllClients();
        mClientAdapter = new ClientAdapter(mDataSet);
        mRecyclerView.setAdapter(mClientAdapter);
        mClientAdapter.setOnClickListener(onClickItem());

        return rootView;
    }

    public ClientAdapter.OnItemClickListener onClickItem(){
        return item -> Toast.makeText(getContext(), item.getName(), Toast.LENGTH_SHORT).show();
    }
}
