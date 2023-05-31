package com.example.apidanilo.Controller.ADMP.CarpetaCuatro;



import com.example.apidanilo.Entity.Subcarpeta_padretres;
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

public class ControllerAddFolderCuatro implements Initializable {


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

       Subcarpeta_padretres subcarpeta_padretres = new Subcarpeta_padretres();


        subcarpeta_padretres.setNombre_padreTres(nombreRaiz.getText());
        subcarpeta_padretres.setDescripcion_padreTres(DescripcionRaiz.getText());
        InsertFolder(subcarpeta_padretres);

        Stage stage = new Stage();
        stage = (Stage) this.crearRaiz.getScene().getWindow();
        stage.close();


    }

    public void InsertFolder(Subcarpeta_padretres subcarpeta_padretres) throws SQLException {


        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();
        String AddQuery = null;

        init(id);


        if (!subcarpeta_padretres.equals("")){
            AddQuery = "INSERT INTO `subcarpeta_padretres` (`idSubcarpeta_padreTres`, `Nombre_padreTres`, `Descripcion_padreTres`, `idSubCarpeta_padreDos`)" +
                    " VALUES (NULL, '"+subcarpeta_padretres.getNombre_padreTres()+"','"+subcarpeta_padretres.getDescripcion_padreTres()+"','"+id+"');";



        }

            pt = connection.prepareStatement(AddQuery, Statement.RETURN_GENERATED_KEYS);
            pt.executeUpdate();

    }


    public void init(long idSubcarpeta_padreDos) {
        id = idSubcarpeta_padreDos;
    }
}
