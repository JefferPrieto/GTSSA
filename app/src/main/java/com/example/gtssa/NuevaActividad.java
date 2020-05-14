package com.example.gtssa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.*;
import android.provider.*;
import android.view.*;
import android.widget.*;

public class NuevaActividad extends AppCompatActivity implements View.OnClickListener {
    Button bfecha,bfecha2,ingeButton,backbtn,camera;
    EditText efecha,efecha2;
    TextView nombreFoto;
    private  int dia,mes,ano;
   // private LinearLayout mR1View;
    private int REQUEST_CAMERA;
    String currentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //VALIDACION DE PERMISOS PARA LA CAMARA
        if (ContextCompat.checkSelfPermission(NuevaActividad.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(NuevaActividad.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(NuevaActividad.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.nueva_actividad);
       // mR1View = (LinearLayout) findViewById(R.id.screenId);
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
        camera=(Button)findViewById(R.id.formCamera);
        camera.setOnClickListener(this);
        nombreFoto=(TextView)findViewById(R.id.nombreFoto);

    }
    @Override
    public void onClick(View v) {
        final View temp = v;
        //calendarios
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

        if(v==camera){
            takePictureIntent();
        }



}

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        //Borrar este comentario
        currentPhotoPath = image.getAbsolutePath();
        nombreFoto.setText(imageFileName);
        return image;
    }

    private void takePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI.toString());
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            //imageView.setImageBitmap(imageBitmap);
        }
    }

}
