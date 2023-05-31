package com.example.apidanilo.Entity;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class carpeta_padre {

    private LongProperty idCarpeta = new SimpleLongProperty();
    private StringProperty Titulo = new SimpleStringProperty();
    private StringProperty Descripcion_padre = new SimpleStringProperty();

    public carpeta_padre() {
    }

    public carpeta_padre(LongProperty idCarpeta) {
        this.idCarpeta = idCarpeta;
    }

    public carpeta_padre(LongProperty idCarpeta, StringProperty titulo, StringProperty descripcion_padre) {
        this.idCarpeta = idCarpeta;
        Titulo = titulo;
        Descripcion_padre = descripcion_padre;
    }

    public carpeta_padre(StringProperty titulo, StringProperty descripcion_padre) {
        Titulo = titulo;
        Descripcion_padre = descripcion_padre;
    }

    public long getIdCarpeta() {
        return idCarpeta.get();
    }

    public LongProperty idCarpetaProperty() {
        return idCarpeta;
    }

    public void setIdCarpeta(long idCarpeta) {
        this.idCarpeta.set(idCarpeta);
    }

    public String getTitulo() {
        return Titulo.get();
    }

    public StringProperty tituloProperty() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        this.Titulo.set(titulo);
    }

    public String getDescripcion_padre() {
        return Descripcion_padre.get();
    }

    public StringProperty descripcion_padreProperty() {
        return Descripcion_padre;
    }

    public void setDescripcion_padre(String descripcion_padre) {
        this.Descripcion_padre.set(descripcion_padre);
    }
}
