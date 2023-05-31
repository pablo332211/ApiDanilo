package com.example.apidanilo.Entity;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Subcarpetas_padreuno {

    private LongProperty idSubcarpeta_padreUno = new SimpleLongProperty();
    private StringProperty Nombre_padreUno = new SimpleStringProperty();
    private StringProperty Descripcion_padreUno = new SimpleStringProperty();
    private LongProperty Datos_Cargados_E = new SimpleLongProperty();

    private LongProperty Carpeta_Padre_idCarpeta = new SimpleLongProperty();

    public Subcarpetas_padreuno() {
    }

    public Subcarpetas_padreuno(LongProperty idSubcarpeta_padreUno) {
        this.idSubcarpeta_padreUno = idSubcarpeta_padreUno;
    }

    public Subcarpetas_padreuno(StringProperty nombre_padreUno, StringProperty descripcion_padreUno, LongProperty datos_Cargados_E) {
        Nombre_padreUno = nombre_padreUno;
        Descripcion_padreUno = descripcion_padreUno;
        Datos_Cargados_E = datos_Cargados_E;
    }

    public Subcarpetas_padreuno(LongProperty idSubcarpeta_padreUno, StringProperty nombre_padreUno, StringProperty descripcion_padreUno, LongProperty datos_Cargados_E) {
        this.idSubcarpeta_padreUno = idSubcarpeta_padreUno;
        Nombre_padreUno = nombre_padreUno;
        Descripcion_padreUno = descripcion_padreUno;
        Datos_Cargados_E = datos_Cargados_E;
    }

    public Subcarpetas_padreuno(LongProperty idSubcarpeta_padreUno, StringProperty nombre_padreUno, StringProperty descripcion_padreUno, LongProperty datos_Cargados_E, LongProperty carpeta_Padre_idCarpeta) {
        this.idSubcarpeta_padreUno = idSubcarpeta_padreUno;
        Nombre_padreUno = nombre_padreUno;
        Descripcion_padreUno = descripcion_padreUno;
        Datos_Cargados_E = datos_Cargados_E;
        Carpeta_Padre_idCarpeta = carpeta_Padre_idCarpeta;
    }

    public long getIdSubcarpeta_padreUno() {
        return idSubcarpeta_padreUno.get();
    }

    public LongProperty idSubcarpeta_padreUnoProperty() {
        return idSubcarpeta_padreUno;
    }

    public void setIdSubcarpeta_padreUno(long idSubcarpeta_padreUno) {
        this.idSubcarpeta_padreUno.set(idSubcarpeta_padreUno);
    }

    public String getNombre_padreUno() {
        return Nombre_padreUno.get();
    }

    public StringProperty nombre_padreUnoProperty() {
        return Nombre_padreUno;
    }

    public void setNombre_padreUno(String nombre_padreUno) {
        this.Nombre_padreUno.set(nombre_padreUno);
    }

    public String getDescripcion_padreUno() {
        return Descripcion_padreUno.get();
    }

    public StringProperty descripcion_padreUnoProperty() {
        return Descripcion_padreUno;
    }

    public void setDescripcion_padreUno(String descripcion_padreUno) {
        this.Descripcion_padreUno.set(descripcion_padreUno);
    }

    public long getDatos_Cargados_E() {
        return Datos_Cargados_E.get();
    }

    public LongProperty datos_Cargados_EProperty() {
        return Datos_Cargados_E;
    }

    public void setDatos_Cargados_E(long datos_Cargados_E) {
        this.Datos_Cargados_E.set(datos_Cargados_E);
    }

    public long getCarpeta_Padre_idCarpeta() {
        return Carpeta_Padre_idCarpeta.get();
    }

    public LongProperty carpeta_Padre_idCarpetaProperty() {
        return Carpeta_Padre_idCarpeta;
    }

    public void setCarpeta_Padre_idCarpeta(long carpeta_Padre_idCarpeta) {
        this.Carpeta_Padre_idCarpeta.set(carpeta_Padre_idCarpeta);
    }
}
