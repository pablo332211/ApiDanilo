package com.example.apidanilo.Controller.ADMP.CarpetaCinco;



import com.example.apidanilo.Entity.Subcarpeta_padrecuatro;
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

public class ControllerAddFolderCinco implements Initializable {


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

       Subcarpeta_padrecuatro subcarpeta_padrecuatro = new Subcarpeta_padrecuatro();


        subcarpeta_padrecuatro.setNombre_padreCuatro(nombreRaiz.getText());
        subcarpeta_padrecuatro.setDescripcion_padreCuatro(DescripcionRaiz.getText());
        InsertFolder(subcarpeta_padrecuatro);

        Stage stage = new Stage();
        stage = (Stage) this.crearRaiz.getScene().getWindow();
        stage.close();


    }

    public void InsertFolder(Subcarpeta_padrecuatro subcarpeta_padrecuatro) throws SQLException {


        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();
        String AddQuery = null;

        init(id);


        if (!subcarpeta_padrecuatro.equals("")){
            AddQuery = "INSERT INTO `subcarpeta_padrecuatro` (`idSubcarpeta_padreCuatro`, `Nombre_padreCuatro`, `Descripcion_padreCuatro`, `Subcarpeta_padreTres_idSubcarpeta_padreTres`)" +
                    " VALUES (NULL, '"+subcarpeta_padrecuatro.getNombre_padreCuatro()+"','"+subcarpeta_padrecuatro.getDescripcion_padreCuatro()+"','"+id+"');";


        }

            pt = connection.prepareStatement(AddQuery, Statement.RETURN_GENERATED_KEYS);
            pt.executeUpdate();

    }


    public void init(long idSubcarpeta_padreTres) {

        id = idSubcarpeta_padreTres;
    }
}
