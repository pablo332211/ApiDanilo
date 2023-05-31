package com.example.apidanilo.Entity;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Administrador_s {

    private LongProperty Cedula_s = new SimpleLongProperty();
    private StringProperty Contrasena_s = new SimpleStringProperty();
    private StringProperty Nombre_s = new SimpleStringProperty();
    private StringProperty ApellidoA_s = new SimpleStringProperty();
    private StringProperty ApellidoB_s = new SimpleStringProperty();

    public Administrador_s() {
    }

    public Administrador_s(LongProperty cedula_s) {
        Cedula_s = cedula_s;
    }

    public Administrador_s(LongProperty cedula_s, StringProperty contrasena_s, StringProperty nombre_s, StringProperty apellidoA_s, StringProperty apellidoB_s) {
        Cedula_s = cedula_s;
        Contrasena_s = contrasena_s;
        Nombre_s = nombre_s;
        ApellidoA_s = apellidoA_s;
        ApellidoB_s = apellidoB_s;
    }

    public Administrador_s(StringProperty contrasena_s, StringProperty nombre_s, StringProperty apellidoA_s, StringProperty apellidoB_s) {
        Contrasena_s = contrasena_s;
        Nombre_s = nombre_s;
        ApellidoA_s = apellidoA_s;
        ApellidoB_s = apellidoB_s;
    }

    public long getCedula_s() {
        return Cedula_s.get();
    }

    public LongProperty cedula_sProperty() {
        return Cedula_s;
    }

    public void setCedula_s(long cedula_s) {
        this.Cedula_s.set(cedula_s);
    }

    public String getContrasena_s() {
        return Contrasena_s.get();
    }

    public StringProperty contrasena_sProperty() {
        return Contrasena_s;
    }

    public void setContrasena_s(String contrasena_s) {
        this.Contrasena_s.set(contrasena_s);
    }

    public String getNombre_s() {
        return Nombre_s.get();
    }

    public StringProperty nombre_sProperty() {
        return Nombre_s;
    }

    public void setNombre_s(String nombre_s) {
        this.Nombre_s.set(nombre_s);
    }

    public String getApellidoA_s() {
        return ApellidoA_s.get();
    }

    public StringProperty apellidoA_sProperty() {
        return ApellidoA_s;
    }

    public void setApellidoA_s(String apellidoA_s) {
        this.ApellidoA_s.set(apellidoA_s);
    }

    public String getApellidoB_s() {
        return ApellidoB_s.get();
    }

    public StringProperty apellidoB_sProperty() {
        return ApellidoB_s;
    }

    public void setApellidoB_s(String apellidoB_s) {
        this.ApellidoB_s.set(apellidoB_s);
    }
}
