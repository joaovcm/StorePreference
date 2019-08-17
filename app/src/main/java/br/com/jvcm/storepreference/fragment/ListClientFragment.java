package br.com.jvcm.storepreference.fragment;

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
import br.com.jvcm.storepreference.adapter.ClientAdapter;
import br.com.jvcm.storepreference.manager.ClientsModel;

public class ListClientFragment extends Fragment {


    public static ListClientFragment newInstance() {
        ListClientFragment fragment = new ListClientFragment();
        return fragment;
    }

    private RecyclerView mRecyclerView;
    private List<ClientsModel> mClientModel = new ArrayList<>();
    private ClientAdapter mClientAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container , true);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);

        return rootView;
    }
}
