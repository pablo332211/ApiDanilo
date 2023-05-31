package com.example.apidanilo.Controller.ADMP;

import com.example.apidanilo.Dao.carpeta_padreDAO;
import com.example.apidanilo.Entity.carpeta_padre;
import com.example.apidanilo.Util.ConectionBD;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerAddFolderRaiz implements Initializable {


    @FXML
    private TextField nombreRaiz;

    @FXML
    private TextField DescripcionRaiz;

    @FXML
    private Button crearRaiz;
    @FXML
    private Button cancelarRaiz;




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

       carpeta_padre Capeta_padre = new carpeta_padre();
       carpeta_padreDAO Carpeta_padreDAO = new carpeta_padreDAO();

        Capeta_padre.setTitulo(nombreRaiz.getText());
        Capeta_padre.setDescripcion_padre(DescripcionRaiz.getText());

        Carpeta_padreDAO.create(Capeta_padre);

        Stage stage = new Stage();
        stage = (Stage) this.crearRaiz.getScene().getWindow();
        stage.close();

    }

    public void InsertFolder(carpeta_padre Carpeta_padre) throws SQLException {


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


}
