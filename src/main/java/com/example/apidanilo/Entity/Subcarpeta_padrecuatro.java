package com.example.apidanilo.Entity;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Subcarpeta_padrecuatro {

    private LongProperty idSubcarpeta_padreCuatro = new SimpleLongProperty();
    private StringProperty Nombre_padreCuatro = new SimpleStringProperty();
    private StringProperty Descripcion_padreCuatro = new SimpleStringProperty();
    private LongProperty Subcarpeta_padreTres_idSubcarpeta_padreTres = new SimpleLongProperty();

    public Subcarpeta_padrecuatro() {
    }

    public Subcarpeta_padrecuatro(LongProperty idSubcarpeta_padreCuatro) {
        this.idSubcarpeta_padreCuatro = idSubcarpeta_padreCuatro;
    }

    public Subcarpeta_padrecuatro(StringProperty nombre_padreCuatro, StringProperty descripcion_padreCuatro, LongProperty subcarpeta_padreTres_idSubcarpeta_padreTres) {
        Nombre_padreCuatro = nombre_padreCuatro;
        Descripcion_padreCuatro = descripcion_padreCuatro;
        Subcarpeta_padreTres_idSubcarpeta_padreTres = subcarpeta_padreTres_idSubcarpeta_padreTres;
    }


    public Subcarpeta_padrecuatro(LongProperty idSubcarpeta_padreCuatro, StringProperty nombre_padreCuatro, StringProperty descripcion_padreCuatro, LongProperty subcarpeta_padreTres_idSubcarpeta_padreTres) {
        this.idSubcarpeta_padreCuatro = idSubcarpeta_padreCuatro;
        Nombre_padreCuatro = nombre_padreCuatro;
        Descripcion_padreCuatro = descripcion_padreCuatro;
        Subcarpeta_padreTres_idSubcarpeta_padreTres = subcarpeta_padreTres_idSubcarpeta_padreTres;
    }

    public long getIdSubcarpeta_padreCuatro() {
        return idSubcarpeta_padreCuatro.get();
    }

    public LongProperty idSubcarpeta_padreCuatroProperty() {
        return idSubcarpeta_padreCuatro;
    }

    public void setIdSubcarpeta_padreCuatro(long idSubcarpeta_padreCuatro) {
        this.idSubcarpeta_padreCuatro.set(idSubcarpeta_padreCuatro);
    }

    public String getNombre_padreCuatro() {
        return Nombre_padreCuatro.get();
    }

    public StringProperty nombre_padreCuatroProperty() {
        return Nombre_padreCuatro;
    }

    public void setNombre_padreCuatro(String nombre_padreCuatro) {
        this.Nombre_padreCuatro.set(nombre_padreCuatro);
    }

    public String getDescripcion_padreCuatro() {
        return Descripcion_padreCuatro.get();
    }

    public StringProperty descripcion_padreCuatroProperty() {
        return Descripcion_padreCuatro;
    }

    public void setDescripcion_padreCuatro(String descripcion_padreCuatro) {
        this.Descripcion_padreCuatro.set(descripcion_padreCuatro);
    }

    public long getSubcarpeta_padreTres_idSubcarpeta_padreTres() {
        return Subcarpeta_padreTres_idSubcarpeta_padreTres.get();
    }

    public LongProperty subcarpeta_padreTres_idSubcarpeta_padreTresProperty() {
        return Subcarpeta_padreTres_idSubcarpeta_padreTres;
    }

    public void setSubcarpeta_padreTres_idSubcarpeta_padreTres(long subcarpeta_padreTres_idSubcarpeta_padreTres) {
        this.Subcarpeta_padreTres_idSubcarpeta_padreTres.set(subcarpeta_padreTres_idSubcarpeta_padreTres);
    }
}
