package com.example.apidanilo.Entity;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Profile {


    private long idProfiles;
    private String Tipo_profiles;

    public Profile() {
    }

    public Profile(long idProfiles) {
        this.idProfiles = idProfiles;
    }

    public Profile(long idProfiles, String tipo_profiles) {
        this.idProfiles = idProfiles;
        Tipo_profiles = tipo_profiles;
    }


    public long getIdProfiles() {
        return idProfiles;
    }

    public void setIdProfiles(long idProfiles) {
        this.idProfiles = idProfiles;
    }

    public String getTipo_profiles() {
        return Tipo_profiles;
    }

    public void setTipo_profiles(String tipo_profiles) {
        Tipo_profiles = tipo_profiles;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "idProfiles=" + idProfiles +
                ", Tipo_profiles='" + Tipo_profiles + '\'' +
                '}';
    }
}
