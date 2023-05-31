package com.example.apidanilo.Controller.ADMP.CarpetaTres;


import com.example.apidanilo.Entity.Subcarpeta_padredos;
import com.example.apidanilo.Entity.Subcarpetas_padreuno;
import com.example.apidanilo.Util.ConectionBD;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerAddFolderTres implements Initializable {


    @FXML
    private TextField nombreRaiz;

    @FXML
    private TextField DescripcionRaiz;

    @FXML
    private Button crearRaiz;
    @FXML
    private Button cancelarRaiz;

    private long id;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void CancelarRaiz(MouseEvent event) {

        Stage stage = new Stage();
        stage = (Stage) this.cancelarRaiz.getScene().getWindow();
        stage.close();

    }

    @FXML
    void CrearRaiz(MouseEvent event) throws SQLException {

       Subcarpeta_padredos subcarpeta_padredos = new Subcarpeta_padredos();


        subcarpeta_padredos.setNombre_padreDos(nombreRaiz.getText());
        subcarpeta_padredos.setDescripcion_padreDos(DescripcionRaiz.getText());
        InsertFolder(subcarpeta_padredos);

        Stage stage = new Stage();
        stage = (Stage) this.crearRaiz.getScene().getWindow();
        stage.close();


    }

    public void InsertFolder(Subcarpeta_padredos subcarpeta_padredos) throws SQLException {


        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();
        String AddQuery = null;

        init(id);


        if (!subcarpeta_padredos.equals("")){
            AddQuery = "INSERT INTO `subcarpeta_padredos` (`idSubcarpeta_padreDos`, `Nombre_padreDos`, `Descripcion_padreDos`, `SubCarpetas_padreUno`)" +
                    " VALUES (NULL, '"+subcarpeta_padredos.getNombre_padreDos()+"','"+subcarpeta_padredos.getDescripcion_padreDos()+"','"+id+"');";


        }

            pt = connection.prepareStatement(AddQuery, Statement.RETURN_GENERATED_KEYS);
            pt.executeUpdate();

    }


    public void init(long idSubcarpeta_padreUno) {
        id = idSubcarpeta_padreUno;
    }
}
