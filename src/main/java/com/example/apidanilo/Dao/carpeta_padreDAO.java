package com.example.apidanilo.Dao;

import com.example.apidanilo.Entity.carpeta_padre;
import com.example.apidanilo.Util.ConectionBD;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class carpeta_padreDAO implements CRUDDAOIMPL{

    carpeta_padre Carpeta_padre = new carpeta_padre();
    long id;


    private static String SQLCREATE  = "";

    private String SQLUPDATE = "UPDATE carpeta_padre SET Titulo = '"+Carpeta_padre.getTitulo()+"', Descripcion_padre = '"+Carpeta_padre.getDescripcion_padre()+"'" +
                               " WHERE idCarpeta = '"+id+"' AND Administrador_P_Cedula_p = 1023005364 AND Administrador_S_Cedula_s = 1023";


    private static String SQLDELETE  = "";
    private String SQLREAD  = "SELECT * FROM  carpeta_padre";




    @Override
    public List<carpeta_padre> listAll() throws SQLException {
        Connection connection = null;
        PreparedStatement pt = null;
        ResultSet resultSet = null;
        carpeta_padre Carpeta_padre = null;
        ObjectProperty<carpeta_padre> objCapeta_padre = new SimpleObjectProperty<>();

        ObservableList<carpeta_padre> Carpeta_padresList = FXCollections.observableArrayList();


        connection = ConectionBD.connectionMYSQL();
        pt = connection.prepareStatement(SQLREAD);
        resultSet = pt.executeQuery();

        while (resultSet.next()){
            Carpeta_padre = new carpeta_padre();
            Carpeta_padre.setIdCarpeta(resultSet.getLong("idCarpeta"));
            Carpeta_padre.setTitulo(resultSet.getString("Titulo"));
            Carpeta_padre.setDescripcion_padre(resultSet.getString("Descripcion_padre"));
            Carpeta_padresList.add(Carpeta_padre);

        }

        ConectionBD.close(connection);
        ConectionBD.close(pt);
        ConectionBD.close(resultSet);

        return Carpeta_padresList;
    }

    @Override
    public void create(Object obj) throws SQLException {

        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();

        String AddQuery = null;

        if (!Carpeta_padre.equals("")){
            AddQuery = "INSERT INTO carpeta_padre(Titulo, Descripcion_padre, Administrador_P_Cedula_p, Administrador_S_Cedula_s)" +
                    " VALUES ('"+Carpeta_padre.getTitulo()+"','"+Carpeta_padre.getDescripcion_padre()+"', '1023005364', '1023');";

        }

        pt = connection.prepareStatement(AddQuery, Statement.RETURN_GENERATED_KEYS);
        pt.executeUpdate();


    }




    @Override
    public void delete(Object obj) {

    }

    @Override
    public void modify(Object obj) throws SQLException {
        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();
        init(id);
        pt = connection.prepareStatement(SQLUPDATE, Statement.RETURN_GENERATED_KEYS);
        pt.executeUpdate();

    }


    public void init(long idCarpeta) {
        id = idCarpeta;
    }
}
