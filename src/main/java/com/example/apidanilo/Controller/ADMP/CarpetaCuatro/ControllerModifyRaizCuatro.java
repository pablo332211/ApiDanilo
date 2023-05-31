package com.example.apidanilo.Controller.ADMP.CarpetaCuatro;


import com.example.apidanilo.Entity.Subcarpeta_padretres;
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

public class ControllerModifyRaizCuatro implements Initializable {


    @FXML
    private TextField nombreRaiz;

    @FXML
    private Button modifyRaiz;

    @FXML
    private TextField DescripcionRaiz;

    @FXML
    private Button cancelarRaiz;

    private ObservableList<Subcarpeta_padretres> subcarpetas_padretresList = FXCollections.observableArrayList();

    private Subcarpeta_padretres subcarpeta_padretres;

    private long idSTres;

    private long idSDos;


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

        Subcarpeta_padretres subcarpeta_padretres = new Subcarpeta_padretres();

        subcarpeta_padretres.setNombre_padreTres(nombreRaiz.getText());
        subcarpeta_padretres.setDescripcion_padreTres(DescripcionRaiz.getText());

        updateCarpetarRaiz(subcarpeta_padretres);

        Stage stage = new Stage();
        stage = (Stage) this.modifyRaiz.getScene().getWindow();
        stage.close();

    }


    //METODOS CREADOS


    public void updateCarpetarRaiz(Subcarpeta_padretres subcarpeta_padretres) throws SQLException {


        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();
        String AddQuery = null;


        initAttributtesCuatro(idSTres, subcarpeta_padretres.getNombre_padreTres(), subcarpeta_padretres.getDescripcion_padreTres(), idSDos);

            if (!subcarpeta_padretres.equals("")){
            AddQuery = "UPDATE subcarpeta_padretres SET Nombre_padreTres = '"+subcarpeta_padretres.getNombre_padreTres()+"', Descripcion_padreTres = '"+subcarpeta_padretres.getDescripcion_padreTres()+"'" +
                    " WHERE idSubcarpeta_padreTres = '"+idSTres+"' AND idSubCarpeta_padreDos = '"+idSDos+"'";







        }

        pt = connection.prepareStatement(AddQuery, Statement.RETURN_GENERATED_KEYS);
        pt.executeUpdate();

    }


    public void initAttributtesCuatro(long idSubcarpeta_padreTres, String nombre_padreTres, String descripcion_padreTres, long idSubcarpeta_padreDos) {

        idSTres = idSubcarpeta_padreTres;
        idSDos = idSubcarpeta_padreDos;
        nombreRaiz.setText(nombre_padreTres);
        DescripcionRaiz.setText(descripcion_padreTres);

    }


    public Subcarpeta_padretres getSubTres() {
        return subcarpeta_padretres;
    }


}
