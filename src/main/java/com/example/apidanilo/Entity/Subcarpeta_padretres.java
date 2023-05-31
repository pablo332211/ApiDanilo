package com.example.apidanilo.Entity;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Subcarpeta_padretres {

    private LongProperty idSubcarpeta_padreTres = new SimpleLongProperty();
    private StringProperty Nombre_padreTres = new SimpleStringProperty();
    private StringProperty Descripcion_padreTres = new SimpleStringProperty();
    private LongProperty idSubcarpeta_padreDos = new SimpleLongProperty();

    public Subcarpeta_padretres() {
    }

    public Subcarpeta_padretres(LongProperty idSubcarpeta_padreTres) {
        this.idSubcarpeta_padreTres = idSubcarpeta_padreTres;
    }

    public Subcarpeta_padretres(StringProperty nombre_padreTres, StringProperty descripcion_padreTres, LongProperty idSubcarpeta_padreDos) {
        Nombre_padreTres = nombre_padreTres;
        Descripcion_padreTres = descripcion_padreTres;
        this.idSubcarpeta_padreDos = idSubcarpeta_padreDos;
    }

    public Subcarpeta_padretres(LongProperty idSubcarpeta_padreTres, StringProperty nombre_padreTres, StringProperty descripcion_padreTres, LongProperty idSubcarpeta_padreDos) {
        this.idSubcarpeta_padreTres = idSubcarpeta_padreTres;
        Nombre_padreTres = nombre_padreTres;
        Descripcion_padreTres = descripcion_padreTres;
        this.idSubcarpeta_padreDos = idSubcarpeta_padreDos;
    }

    public long getIdSubcarpeta_padreTres() {
        return idSubcarpeta_padreTres.get();
    }

    public LongProperty idSubcarpeta_padreTresProperty() {
        return idSubcarpeta_padreTres;
    }

    public void setIdSubcarpeta_padreTres(long idSubcarpeta_padreTres) {
        this.idSubcarpeta_padreTres.set(idSubcarpeta_padreTres);
    }

    public String getNombre_padreTres() {
        return Nombre_padreTres.get();
    }

    public StringProperty nombre_padreTresProperty() {
        return Nombre_padreTres;
    }

    public void setNombre_padreTres(String nombre_padreTres) {
        this.Nombre_padreTres.set(nombre_padreTres);
    }

    public String getDescripcion_padreTres() {
        return Descripcion_padreTres.get();
    }

    public StringProperty descripcion_padreTresProperty() {
        return Descripcion_padreTres;
    }

    public void setDescripcion_padreTres(String descripcion_padreTres) {
        this.Descripcion_padreTres.set(descripcion_padreTres);
    }

    public long getIdSubcarpeta_padreDos() {
        return idSubcarpeta_padreDos.get();
    }

    public LongProperty idSubcarpeta_padreDosProperty() {
        return idSubcarpeta_padreDos;
    }

    public void setIdSubcarpeta_padreDos(long idSubcarpeta_padreDos) {
        this.idSubcarpeta_padreDos.set(idSubcarpeta_padreDos);
    }
}
