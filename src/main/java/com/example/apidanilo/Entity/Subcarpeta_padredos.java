package com.example.apidanilo.Entity;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Subcarpeta_padredos {

    private LongProperty idSubcarpeta_padreDos = new SimpleLongProperty();
    private StringProperty Nombre_padreDos = new SimpleStringProperty();
    private StringProperty Descripcion_padreDos = new SimpleStringProperty();

    //FK
    private LongProperty SubCarpetas_padreUno = new SimpleLongProperty();

    public Subcarpeta_padredos() {
    }

    public Subcarpeta_padredos(LongProperty idSubcarpeta_padreDos) {
        this.idSubcarpeta_padreDos = idSubcarpeta_padreDos;
    }

    public Subcarpeta_padredos(StringProperty nombre_padreDos, StringProperty descripcion_padreDos, LongProperty subCarpetas_padreUno) {
        Nombre_padreDos = nombre_padreDos;
        Descripcion_padreDos = descripcion_padreDos;
        SubCarpetas_padreUno = subCarpetas_padreUno;
    }

    public Subcarpeta_padredos(LongProperty idSubcarpeta_padreDos, StringProperty nombre_padreDos, StringProperty descripcion_padreDos, LongProperty subCarpetas_padreUno) {
        this.idSubcarpeta_padreDos = idSubcarpeta_padreDos;
        Nombre_padreDos = nombre_padreDos;
        Descripcion_padreDos = descripcion_padreDos;
        SubCarpetas_padreUno = subCarpetas_padreUno;
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

    public String getNombre_padreDos() {
        return Nombre_padreDos.get();
    }

    public StringProperty nombre_padreDosProperty() {
        return Nombre_padreDos;
    }

    public void setNombre_padreDos(String nombre_padreDos) {
        this.Nombre_padreDos.set(nombre_padreDos);
    }

    public String getDescripcion_padreDos() {
        return Descripcion_padreDos.get();
    }

    public StringProperty descripcion_padreDosProperty() {
        return Descripcion_padreDos;
    }

    public void setDescripcion_padreDos(String descripcion_padreDos) {
        this.Descripcion_padreDos.set(descripcion_padreDos);
    }

    public long getSubCarpetas_padreUno() {
        return SubCarpetas_padreUno.get();
    }

    public LongProperty subCarpetas_padreUnoProperty() {
        return SubCarpetas_padreUno;
    }

    public void setSubCarpetas_padreUno(long subCarpetas_padreUno) {
        this.SubCarpetas_padreUno.set(subCarpetas_padreUno);
    }
}
