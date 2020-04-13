package com.example.gtssa;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.app.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bfecha,bfecha2;
    EditText efecha,efecha2;
    private  int dia,mes,ano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bfecha=(Button)findViewById(R.id.button1);
        bfecha2=(Button)findViewById(R.id.button2);
        efecha=(EditText)findViewById(R.id.fechaInicio);
        efecha2=(EditText)findViewById(R.id.fechaFinal);

        bfecha.setOnClickListener(this);
        bfecha2.setOnClickListener(this);
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
}
}
