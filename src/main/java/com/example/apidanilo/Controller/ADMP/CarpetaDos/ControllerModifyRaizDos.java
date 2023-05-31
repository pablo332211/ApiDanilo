package com.example.apidanilo.Controller.ADMP.CarpetaDos;

import com.example.apidanilo.Entity.Subcarpetas_padreuno;
import com.example.apidanilo.Entity.carpeta_padre;
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

public class ControllerModifyRaizDos implements Initializable {


    @FXML
    private TextField nombreRaiz;

    @FXML
    private Button modifyRaiz;

    @FXML
    private TextField DescripcionRaiz;

    @FXML
    private Button cancelarRaiz;

    private ObservableList<Subcarpetas_padreuno> subcarpetas_padreunoList = FXCollections.observableArrayList();

    private Subcarpetas_padreuno subcarpetas_padreuno;

    private long idSuno;

    private long idP;


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

        Subcarpetas_padreuno subcarpetas_Padreuno = new Subcarpetas_padreuno();

        subcarpetas_Padreuno.setNombre_padreUno(nombreRaiz.getText());
        subcarpetas_Padreuno.setDescripcion_padreUno(DescripcionRaiz.getText());

        updateCarpetarRaiz(subcarpetas_Padreuno);

        Stage stage = new Stage();
        stage = (Stage) this.modifyRaiz.getScene().getWindow();
        stage.close();

    }


    //METODOS CREADOS


    public void updateCarpetarRaiz(Subcarpetas_padreuno subcarpetas_padreuno) throws SQLException {


        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();
        String AddQuery = null;
        initAttributtesDos(idSuno, subcarpetas_padreuno.getNombre_padreUno(), subcarpetas_padreuno.getDescripcion_padreUno(), idP);

        if (!subcarpetas_padreuno.equals("")){
            AddQuery = "UPDATE subcarpetas_padreuno SET Nombre_padreUno = '"+subcarpetas_padreuno.getNombre_padreUno()+"', Descripcion_padreUno = '"+subcarpetas_padreuno.getDescripcion_padreUno()+"'" +
                    " WHERE idSubcarpeta_padreUno = '"+idSuno+"' AND Carpeta_Padre_idCarpeta = '"+idP+"' AND Datos_Cargados_E = 1";






        }

        pt = connection.prepareStatement(AddQuery, Statement.RETURN_GENERATED_KEYS);
        pt.executeUpdate();

    }

    public void initAttributtesDos(long idSubcarpeta_padreUno, String nombre_padreUno, String descripcion_padreUno, long idCarpeta) {
        idSuno = idSubcarpeta_padreUno;
        idP = idCarpeta;
        nombreRaiz.setText(nombre_padreUno);
        DescripcionRaiz.setText(descripcion_padreUno);
    }


    public Subcarpetas_padreuno getSubUno() {
        return subcarpetas_padreuno;
    }
}
