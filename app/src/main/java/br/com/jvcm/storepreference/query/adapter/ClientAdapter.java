package br.com.jvcm.storepreference.query.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import br.com.jvcm.storepreference.R;
import br.com.jvcm.storepreference.core.ClientComposite;
import br.com.jvcm.storepreference.dto.ClientDTO;
import br.com.jvcm.storepreference.dto.ClientsModel;

public class  ClientAdapter extends RecyclerView.Adapter<ClientAdapter.DataObjectHolder> {

    private List<ClientDTO> mDataSet;
    private OnItemClickListener mListener;


    public ClientAdapter(List<ClientDTO> dataSet) {
        mDataSet = dataSet;
    }

    public void setOnClickListener(OnItemClickListener listener){
        mListener = listener;

    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View cellView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_client, viewGroup, false);

        DataObjectHolder objectHolder = new DataObjectHolder(cellView);
        return objectHolder;
    }
    public void onBindViewHolder(DataObjectHolder holder, int i) {
        ClientDTO set = mDataSet.get(i);

        holder.tvClientName.setText(set.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(mDataSet.get(i));
                }
            }
        });

    }

    public int getItemCount() {
        return mDataSet.size();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView tvClientName;


        public DataObjectHolder(@NonNull View itemView) {
            super(itemView);

            tvClientName = itemView.findViewById(R.id.tv_name_client);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(ClientDTO item);
    }





}