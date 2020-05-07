package com.example.gtssa;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ListaIngenieros extends AppCompatActivity implements View.OnClickListener{
    //variable del recycler view de lista_ingenieros
    private RecyclerView reInge;
    //variable del adaptador
    private ingeAdapter adapt;
    Button backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_ingenieros);

        backbtn=(Button)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(this);
        reInge=(RecyclerView)findViewById(R.id.recyclerIngenieros);
        reInge.setLayoutManager(new LinearLayoutManager(this));
        adapt=new ingeAdapter(obtenerIngenieros());
        reInge.setAdapter(adapt);


    }

    public ArrayList<ingenieroModelo> obtenerIngenieros() {
        ArrayList<ingenieroModelo> nIngenieros = new ArrayList<>();
        for(int i =0; i<1000; i++) {
            nIngenieros.add(new ingenieroModelo("Juan Gomez", "Costo por hora:  costo de prueba", R.drawable.fotopruebainge));
        }
        return nIngenieros;
    }

    @Override
    public void onClick(View v) {
        if (v==backbtn){
            Intent i = new Intent(ListaIngenieros.this, NuevaActividad.class);
            startActivity(i);
        }
    }
}
