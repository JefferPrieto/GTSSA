package com.example.gtssa;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapterListaActividades extends RecyclerView.Adapter<RecyclerViewAdapterListaActividades.ViewHolder> implements View.OnClickListener {
    private View.OnClickListener listener;
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,fecha;
        ImageView fotoActividad;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.NombreActividad);
            fecha=(TextView)itemView.findViewById(R.id.fechaActividad);
            fotoActividad=(ImageView)itemView.findViewById(R.id.imgActividad);
        }
    }

    public List<ActividadModelo> ActividadLista;

    public RecyclerViewAdapterListaActividades(List<ActividadModelo> actividadLista) {
        this.ActividadLista = actividadLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_actividad,parent,false);
        view.setOnClickListener(this);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(ActividadLista.get(position).getNombre());
        holder.fecha.setText(ActividadLista.get(position).getFecha());
        holder.fotoActividad.setImageResource(ActividadLista.get(position).getImgActividad());
    }

    @Override
    public int getItemCount() {
        return ActividadLista.size();
    }




}
