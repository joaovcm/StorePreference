package br.com.jvcm.storepreference.query.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import br.com.jvcm.storepreference.R;
import br.com.jvcm.storepreference.dto.ClientDTO;
import br.com.jvcm.storepreference.dto.ClientsModel;

public class  ClientAdapter extends RecyclerView.Adapter<ClientAdapter.DataObjectHolder> {

    private List<ClientDTO> mDataset;

    public ClientAdapter(List<ClientsModel> dataSet) {
        ;
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View cellView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_client, viewGroup, false);

        DataObjectHolder objectHolder = new DataObjectHolder(cellView);
        return objectHolder;
    }
    public void onBindViewHolder(DataObjectHolder holder, int i) {
        ClientDTO set = mDataset.get(i);

        holder.tvClientName.setText(set.getName());

    }

    public int getItemCount() {
        return mDataset.size();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView tvClientName;


        public DataObjectHolder(@NonNull View itemView) {
            super(itemView);

            tvClientName = itemView.findViewById(R.id.tv_name_client);

        }
    }

}