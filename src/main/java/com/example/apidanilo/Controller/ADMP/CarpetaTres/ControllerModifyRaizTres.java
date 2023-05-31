package com.example.apidanilo.Controller.ADMP.CarpetaTres;

import com.example.apidanilo.Entity.Subcarpeta_padredos;
import com.example.apidanilo.Util.ConectionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ControllerModifyRaizTres implements Initializable {


    @FXML
    private TextField nombreRaiz;

    @FXML
    private Button modifyRaiz;

    @FXML
    private TextField DescripcionRaiz;

    @FXML
    private Button cancelarRaiz;

    private ObservableList<Subcarpeta_padredos> subcarpetas_padredosList = FXCollections.observableArrayList();

    private Subcarpeta_padredos subcarpeta_padredos;

    private long idSDos;

    private long idSUno;


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

        Subcarpeta_padredos subcarpeta_padredos = new Subcarpeta_padredos();

        subcarpeta_padredos.setNombre_padreDos(nombreRaiz.getText());
        subcarpeta_padredos.setDescripcion_padreDos(DescripcionRaiz.getText());

        updateCarpetarRaiz(subcarpeta_padredos);

        Stage stage = new Stage();
        stage = (Stage) this.modifyRaiz.getScene().getWindow();
        stage.close();

    }


    //METODOS CREADOS


    public void updateCarpetarRaiz(Subcarpeta_padredos subcarpeta_padredos) throws SQLException {


        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();
        String AddQuery = null;
        initAttributtesTres(idSDos, subcarpeta_padredos.getNombre_padreDos(), subcarpeta_padredos.getDescripcion_padreDos(), idSUno);

        if (!subcarpeta_padredos.equals("")){
            AddQuery = "UPDATE subcarpeta_padredos SET Nombre_padreDos = '"+subcarpeta_padredos.getNombre_padreDos()+"', Descripcion_padreDos = '"+subcarpeta_padredos.getDescripcion_padreDos()+"'" +
                    " WHERE idSubcarpeta_padreDos = '"+idSDos+"' AND SubCarpetas_padreUno = '"+idSUno+"'";


            System.out.println(AddQuery);




        }

        pt = connection.prepareStatement(AddQuery, Statement.RETURN_GENERATED_KEYS);
        pt.executeUpdate();

    }

    public void initAttributtesTres(long idSubcarpeta_padreDos, String nombre_padreDos, String descripcion_padreDos, long idSubcarpeta_padreUno) {


        idSDos = idSubcarpeta_padreDos;
        idSUno = idSubcarpeta_padreUno;
        nombreRaiz.setText(nombre_padreDos);
        DescripcionRaiz.setText(descripcion_padreDos);




    }

    public Subcarpeta_padredos getSubDos() {
        return subcarpeta_padredos;
    }
}
