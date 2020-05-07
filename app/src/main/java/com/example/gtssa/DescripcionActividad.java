package com.example.gtssa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DescripcionActividad extends AppCompatActivity implements View.OnClickListener {
    Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descripcion_actividad);
        backbtn=(Button)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==backbtn){
            Intent i = new Intent(DescripcionActividad.this, ListaActividades.class);
            startActivity(i);
        }
    }
}
