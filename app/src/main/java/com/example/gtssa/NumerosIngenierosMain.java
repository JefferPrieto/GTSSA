package com.example.gtssa;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NumerosIngenierosMain extends AppCompatActivity {
    //variable del recycler view de lista_ingenieros
    private RecyclerView reIngeNum;
    //variable del adaptador
    private ingeAdapter adapt;
    Button backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_ingeniero);

        //backbtn=(Button)findViewById(R.id.backbtn);
        //backbtn.setOnClickListener(this);
        reIngeNum=(RecyclerView)findViewById(R.id.numerosInge);
        reIngeNum.setLayoutManager(new LinearLayoutManager(this));
        adapt=new ingeAdapter(obtenerIngenieros());
        reIngeNum.setAdapter(adapt);


    }

    public ArrayList<ingenieroModelo> obtenerIngenieros() {
        ArrayList<ingenieroModelo> nIngenieros = new ArrayList<>();
        for(int i =0; i<1000; i++) {
            nIngenieros.add(new ingenieroModelo("Juan Gomez", "Costo por hora:  sinko peso", R.drawable.fotopruebainge));
        }
        return nIngenieros;
    }
}
