package com.example.apidanilo.Controller.ADMP;

import com.example.apidanilo.Entity.Subcarpetas_padreuno;
import com.example.apidanilo.Entity.carpeta_padre;
import com.example.apidanilo.Util.ConectionBD;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerModifyRaiz implements Initializable {


    @FXML
    private TextField nombreRaiz;

    @FXML
    private Button modifyRaiz;

    @FXML
    private TextField DescripcionRaiz;

    @FXML
    private Button cancelarRaiz;

    private ObservableList<carpeta_padre> Carpeta_padresList = FXCollections.observableArrayList();



    private carpeta_padre Carpeta_padre;

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
    void modifyRaiz(MouseEvent event) throws SQLException {

        carpeta_padre Capeta_padre = new carpeta_padre();


        Capeta_padre.setTitulo(nombreRaiz.getText());
        Capeta_padre.setDescripcion_padre(DescripcionRaiz.getText());

        updateCarpetarRaiz(Capeta_padre);

        Stage stage = new Stage();
        stage = (Stage) this.modifyRaiz.getScene().getWindow();
        stage.close();

    }


    //METODOS CREADOS


    public void updateCarpetarRaiz(carpeta_padre Carpeta_padre) throws SQLException {


        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();
        String AddQuery = null;
        initAttributtes(id, Carpeta_padre.getTitulo(), Carpeta_padre.getDescripcion_padre());

        System.out.println(id);

        if (!Carpeta_padre.equals("")){
            AddQuery = "UPDATE carpeta_padre SET Titulo = '"+Carpeta_padre.getTitulo()+"', Descripcion_padre = '"+Carpeta_padre.getDescripcion_padre()+"' WHERE idCarpeta = '"+id+"' AND Administrador_P_Cedula_p = 1023005364 AND Administrador_S_Cedula_s = 1023";


        }

        pt = connection.prepareStatement(AddQuery, Statement.RETURN_GENERATED_KEYS);
        pt.executeUpdate();

    }

    public void initAttributtes(long idCarpeta, String titulo, String descripcion_padre) {

        id = idCarpeta;
        nombreRaiz.setText(titulo);
        DescripcionRaiz.setText(descripcion_padre);


    }

    public carpeta_padre getPersona() {
        return Carpeta_padre;
    }



}
