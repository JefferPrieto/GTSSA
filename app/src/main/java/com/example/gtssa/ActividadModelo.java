package com.example.gtssa;

public class ActividadModelo {

    private String nombre,fecha;
    private int imgActividad;
    //Se generan dos constructores, uno vacio y otro con parametros

    public ActividadModelo() {
    }

    public ActividadModelo(String nombre, String fecha, int imgActividad) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.imgActividad = imgActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getImgActividad() {
        return imgActividad;
    }

    public void setImgActividad(int imgActividad) {
        this.imgActividad = imgActividad;
    }
}
