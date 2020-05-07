package com.example.gtssa;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
//Este es el adaptador para el RecyclerView
public class ingeAdapter extends RecyclerView.Adapter<ingeAdapter.ViewHolder> {

    ArrayList<ingenieroModelo> listaIngenieros;

    public ingeAdapter(ArrayList<ingenieroModelo> listaIngenieros) {
        this.listaIngenieros = listaIngenieros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingeniero_card,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(listaIngenieros.get(position).getNombre());
        holder.costo.setText(listaIngenieros.get(position).getCostoHora());
        holder.foto.setImageResource(listaIngenieros.get(position).getImgIngeniero());
    }

    @Override
    public int getItemCount() {
        return listaIngenieros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,costo;
        ImageView foto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre= (TextView) itemView.findViewById(R.id.nombre_ingeniero);
            costo=(TextView) itemView.findViewById(R.id.costo_ingeniero);
            foto=itemView.findViewById(R.id.foto_ingeniero);
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
