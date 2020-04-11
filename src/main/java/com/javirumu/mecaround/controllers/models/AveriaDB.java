package com.javirumu.mecaround.controllers.models;

public class AveriaDB{

    private String titulo;
    private String modeloCoche;
    private String descripcion;
    private int presupuestos;
    private String urlFoto;

    public AveriaDB() {
    }

    public AveriaDB(String titulo, String modeloCoche, String descripcion, int presupuestos, String urlFoto) {
        this.titulo = titulo;
        this.modeloCoche = modeloCoche;
        this.descripcion = descripcion;
        this.presupuestos = presupuestos;
        this.urlFoto = urlFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModeloCoche() {
        return modeloCoche;
    }

    public void setModeloCoche(String modeloCoche) {
        this.modeloCoche = modeloCoche;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(int presupuestos) {
        this.presupuestos = presupuestos;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
