package com.example.gtssa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NumIngenierosAdapter extends RecyclerView.Adapter<NumIngenierosAdapter.ViewHolder> {
    public ArrayList<NumeroIngenieroModelo> listaNumeros;

    public NumIngenierosAdapter(ArrayList<NumeroIngenieroModelo> listaNumeros) {
        this.listaNumeros = listaNumeros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.telefono_ingeniero,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.numero.setText(listaNumeros.get(position).getNumero());
    }

    @Override
    public int getItemCount() {
        return listaNumeros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView numero;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numero= (TextView) itemView.findViewById(R.id.numero);
        }
    }
}
