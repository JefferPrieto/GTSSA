package com.example.gtssa;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class NuevaActividad extends AppCompatActivity implements View.OnClickListener {
    Button bfecha,bfecha2,ingeButton,backbtn;
    EditText efecha,efecha2;
    private  int dia,mes,ano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nueva_actividad);

        bfecha=(Button)findViewById(R.id.fInicial);
        bfecha2=(Button)findViewById(R.id.fFinal);
        efecha=(EditText)findViewById(R.id.fechaInicio);
        efecha2=(EditText)findViewById(R.id.fechaFinal);
        bfecha.setOnClickListener(this);
        bfecha2.setOnClickListener(this);
        backbtn=(Button)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(this);
        ingeButton=(Button)findViewById(R.id.addInge);
        ingeButton.setOnClickListener(this);
        //bhora.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        final View temp = v;
        if(v==bfecha||v==bfecha2){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    if(temp==bfecha)efecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    if(temp==bfecha2)efecha2.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia,mes,ano);
            datePickerDialog.show();
        }
        if(v==ingeButton){
            Intent i = new Intent(NuevaActividad.this, ListaIngenieros.class);
            startActivity(i);
        }
        if (v==backbtn){

            Intent i = new Intent(NuevaActividad.this, ListaActividades.class);
            startActivity(i);

        }



}




}
