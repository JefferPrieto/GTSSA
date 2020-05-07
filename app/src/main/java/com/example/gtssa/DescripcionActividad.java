package com.example.gtssa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DescripcionActividad extends AppCompatActivity implements View.OnClickListener {
    Button backbtn;
    //variable del recycler view de lista_ingenieros
    private RecyclerView reInge;
    //variable del adaptador
    private ingeAdapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descripcion_actividad);
        backbtn=(Button)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(this);
        reInge=(RecyclerView)findViewById(R.id.recyclerIngenieros);
        reInge.setLayoutManager(new LinearLayoutManager(this));
        obtenerIngenieros();
        reInge.setAdapter(adapt);
    }
    public void obtenerIngenieros() {
        ArrayList<ingenieroModelo> nIngenieros = new ArrayList<>();
        for(int i =0; i<4; i++) {
            nIngenieros.add(new ingenieroModelo("Juan Gomez", "Costo por hora:  costo de prueba", R.drawable.fotopruebainge));
        }
        adapt = new ingeAdapter(nIngenieros);
        adapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(DescripcionActividad.this, NumerosIngenierosMain.class);
                startActivity(i);
            }
        });

    }
    @Override
    public void onClick(View v) {
        if (v==backbtn){
            Intent i = new Intent(DescripcionActividad.this, ListaActividades.class);
            startActivity(i);
        }
    }
}
