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
    private NumIngenierosAdapter adapt;
    Button backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_ingeniero);

        //backbtn=(Button)findViewById(R.id.backbtn);
        //backbtn.setOnClickListener(this);
        reIngeNum=(RecyclerView)findViewById(R.id.numerosInge);
        reIngeNum.setLayoutManager(new LinearLayoutManager(this));
        obtenerIngenieros();
        reIngeNum.setAdapter(adapt);


    }

    public void obtenerIngenieros() {
        ArrayList<NumeroIngenieroModelo> nIngenieros = new ArrayList<>();
        for(int i =0; i<400; i++) {
            nIngenieros.add(new NumeroIngenieroModelo("2222222222"));
        }
        adapt= new NumIngenierosAdapter(nIngenieros);

    }
}
