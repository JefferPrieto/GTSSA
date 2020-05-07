package com.example.gtssa;
//Esta clase hace referencia a la informacion mostrada en la tarjeta ingeniero
public class ingenieroModelo {
    //Atributos del ingeniero
    private String nombre,costoHora;
    private int imgIngeniero;

    //Se generan constructores, getters y setters


    public ingenieroModelo(String nombre, String costoHora, int imgIngeniero) {
        this.nombre = nombre;
        this.costoHora = costoHora;
        this.imgIngeniero = imgIngeniero;
    }

    public ingenieroModelo() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(String costoHora) {
        this.costoHora = costoHora;
    }

    public int getImgIngeniero() {
        return imgIngeniero;
    }

    public void setImgIngeniero(int imgIngeniero) {
        this.imgIngeniero = imgIngeniero;
    }
}
