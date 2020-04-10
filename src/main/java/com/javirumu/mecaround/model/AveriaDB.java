package com.javirumu.mecaround.model;

import com.javirumu.mecaround.app.MyApp;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AveriaDB extends RealmObject{

    public static final String AVERIADB_ID = "id";
    public static final String AVERIADB_TITULO = "titulo";
    public static final String AVERIADB_MODELOCOCHE = "modeloCoche";


    @PrimaryKey
    private long id;

    private String titulo;
    private String modeloCoche;
    private String urlImagen;
    private int numeroPresupuestos;
    private String descripcion;

    public AveriaDB() {
       this.id = MyApp.AveriaID.incrementAndGet();
    }

    public AveriaDB(String titulo, String modeloCoche, String urlImagen, int numeroPresupuestos, String descripcion
    ) { this.titulo = titulo;
        this.modeloCoche = modeloCoche;
        this.urlImagen = urlImagen;
        this.numeroPresupuestos = numeroPresupuestos;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
