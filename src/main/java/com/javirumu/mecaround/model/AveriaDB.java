package com.javirumu.mecaround.model;

import com.javirumu.mecaround.app.MyApp;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AveriaDB extends RealmObject{

    @PrimaryKey
    private long id;

    private String titulo;
    private String modeloCoche;
    private String urlImagen;
    private int numeroPresupuestos;

    public AveriaDB() {
       this.id = MyApp.AveriaID.incrementAndGet();
    }

    public AveriaDB(String titulo, String modeloCoche, String urlImagen, int numeroPresupuestos) {
        this.titulo = titulo;
        this.modeloCoche = modeloCoche;
        this.urlImagen = urlImagen;
        this.numeroPresupuestos = numeroPresupuestos;
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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getNumeroPresupuestos() {
        return numeroPresupuestos;
    }

    public void setNumeroPresupuestos(int numeroPresupuestos) {
        this.numeroPresupuestos = numeroPresupuestos;
    }
}
