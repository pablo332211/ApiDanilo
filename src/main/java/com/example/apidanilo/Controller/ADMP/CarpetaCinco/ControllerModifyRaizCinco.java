package com.example.apidanilo.Controller.ADMP.CarpetaCinco;


import com.example.apidanilo.Entity.Subcarpeta_padrecuatro;
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

public class ControllerModifyRaizCinco implements Initializable {


    @FXML
    private TextField nombreRaiz;

    @FXML
    private Button modifyRaiz;

    @FXML
    private TextField DescripcionRaiz;

    @FXML
    private Button cancelarRaiz;

    private ObservableList<Subcarpeta_padrecuatro> subcarpetas_padrecuatroList = FXCollections.observableArrayList();

    private Subcarpeta_padrecuatro subcarpeta_padrecuatro;

    private long idSCuatro;

    private long idSTres;


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

        updateCarpetarRaiz(subcarpeta_padrecuatro);

        Stage stage = new Stage();
        stage = (Stage) this.modifyRaiz.getScene().getWindow();
        stage.close();

    }


    //METODOS CREADOS


    public void updateCarpetarRaiz(Subcarpeta_padrecuatro subcarpeta_padrecuatro) throws SQLException {


        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();
        String AddQuery = null;


        initAttributtesCinco(idSTres, subcarpeta_padrecuatro.getNombre_padreCuatro(), subcarpeta_padrecuatro.getDescripcion_padreCuatro(), idSTres);

            if (!subcarpeta_padrecuatro.equals("")){
            AddQuery = "UPDATE subcarpeta_padrecuatro SET Nombre_padreCuatro = '"+subcarpeta_padrecuatro.getNombre_padreCuatro()+"', Descripcion_padreCuatro = '"+subcarpeta_padrecuatro.getDescripcion_padreCuatro()+"'" +
                    " WHERE idSubcarpeta_padreCuatro = '"+idSCuatro+"' AND idSubCarpeta_padreTres = '"+idSTres+"'";

        }

        pt = connection.prepareStatement(AddQuery, Statement.RETURN_GENERATED_KEYS);
        pt.executeUpdate();

    }

    public void initAttributtesCinco(long idSubcarpeta_padreCuatro, String nombre_padreCuatro, String descripcion_padreCuatro, long idSubcarpeta_padreTres) {

        idSCuatro = idSubcarpeta_padreCuatro;
        idSTres = idSubcarpeta_padreTres;
        nombreRaiz.setText(nombre_padreCuatro);
        DescripcionRaiz.setText(descripcion_padreCuatro);

    }

    public Subcarpeta_padrecuatro getSubCuatro() {
        return subcarpeta_padrecuatro;

    }
}
