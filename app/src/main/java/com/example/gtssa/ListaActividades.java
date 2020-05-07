package com.example.gtssa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaActividades extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView reActivi;
    private RecyclerViewAdapterListaActividades adapt;
    FloatingActionButton nuevaA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.nueva_actividad);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_actividades);
        nuevaA=(FloatingActionButton) findViewById(R.id.nuevaAct);
        nuevaA.setOnClickListener(this);
        reActivi=(RecyclerView)findViewById(R.id.RecyclerAct);
        reActivi.setLayoutManager(new LinearLayoutManager(this));
        inflarRecycler();
        reActivi.setAdapter(adapt);


    }

    private void inflarRecycler() {
        ArrayList<ActividadModelo> nActividades = new ArrayList<>();
        for(int i =0; i<1000; i++) {
            nActividades.add(new ActividadModelo("Conexion cableado", "Tiempo restante: 4 meses", R.drawable.fotopruebainge));
        }
        adapt = new RecyclerViewAdapterListaActividades(nActividades);
        adapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaActividades.this, DescripcionActividad.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v==nuevaA){
            Intent i = new Intent(ListaActividades.this, NuevaActividad.class);
            startActivity(i);
        }
    }
}
