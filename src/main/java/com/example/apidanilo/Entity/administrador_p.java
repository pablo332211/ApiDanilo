package com.example.apidanilo.Entity;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class administrador_p {


    private LongProperty Cedula_p = new SimpleLongProperty();
    private StringProperty Contrasena_p = new SimpleStringProperty();
    private StringProperty Nombre_P = new SimpleStringProperty();
    private StringProperty ApellidoA_p = new SimpleStringProperty();
    private StringProperty ApellidoB_p = new SimpleStringProperty();


    public administrador_p() {
    }

    public administrador_p(LongProperty cedula_p) {
        Cedula_p = cedula_p;
    }

    public administrador_p(StringProperty contrasena_p, StringProperty nombre_P, StringProperty apellidoA_p, StringProperty apellidoB_p) {
        Contrasena_p = contrasena_p;
        Nombre_P = nombre_P;
        ApellidoA_p = apellidoA_p;
        ApellidoB_p = apellidoB_p;
    }

    public administrador_p(LongProperty cedula_p, StringProperty contrasena_p, StringProperty nombre_P, StringProperty apellidoA_p, StringProperty apellidoB_p) {
        Cedula_p = cedula_p;
        Contrasena_p = contrasena_p;
        Nombre_P = nombre_P;
        ApellidoA_p = apellidoA_p;
        ApellidoB_p = apellidoB_p;
    }

    public long getCedula_p() {
        return Cedula_p.get();
    }

    public LongProperty cedula_pProperty() {
        return Cedula_p;
    }

    public void setCedula_p(long cedula_p) {
        this.Cedula_p.set(cedula_p);
    }

    public String getContrasena_p() {
        return Contrasena_p.get();
    }

    public StringProperty contrasena_pProperty() {
        return Contrasena_p;
    }

    public void setContrasena_p(String contrasena_p) {
        this.Contrasena_p.set(contrasena_p);
    }

    public String getNombre_P() {
        return Nombre_P.get();
    }

    public StringProperty nombre_PProperty() {
        return Nombre_P;
    }

    public String setNombre_P(String nombre_P) {
        return nombre_P;
    }

    public String getApellidoA_p() {
        return ApellidoA_p.get();
    }

    public StringProperty apellidoA_pProperty() {
        return ApellidoA_p;
    }

    public void setApellidoA_p(String apellidoA_p) {
        this.ApellidoA_p.set(apellidoA_p);
    }

    public String getApellidoB_p() {
        return ApellidoB_p.get();
    }

    public StringProperty apellidoB_pProperty() {
        return ApellidoB_p;
    }

    public void setApellidoB_p(String apellidoB_p) {
        this.ApellidoB_p.set(apellidoB_p);
    }
}
