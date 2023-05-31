package com.example.apidanilo.Controller.ADMP.CarpetaDos;


import com.example.apidanilo.Entity.Subcarpetas_padreuno;
import com.example.apidanilo.Entity.carpeta_padre;
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

public class ControllerAddFolderDos implements Initializable {


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

       Subcarpetas_padreuno subcarpetas_padreuno = new Subcarpetas_padreuno();


        subcarpetas_padreuno.setNombre_padreUno(nombreRaiz.getText());
        subcarpetas_padreuno.setDescripcion_padreUno(DescripcionRaiz.getText());
        InsertFolder(subcarpetas_padreuno);

        Stage stage = new Stage();
        stage = (Stage) this.crearRaiz.getScene().getWindow();
        stage.close();


    }

    public void InsertFolder(Subcarpetas_padreuno subcarpetas_padreuno) throws SQLException {


        Connection connection = null;
        PreparedStatement pt = null;
        connection = ConectionBD.connectionMYSQL();
        String AddQuery = null;

        init(id);


        if (!subcarpetas_padreuno.equals("")){
            AddQuery = "INSERT INTO `subcarpetas_padreuno` (`idSubcarpeta_padreUno`, `Nombre_padreUno`, `Descripcion_padreUno`, `Carpeta_Padre_idCarpeta`, `Datos_Cargados_E`)" +
                    " VALUES (NULL, '"+subcarpetas_padreuno.getNombre_padreUno()+"','"+subcarpetas_padreuno.getDescripcion_padreUno()+"','"+id+"', '1');";


        }

            pt = connection.prepareStatement(AddQuery, Statement.RETURN_GENERATED_KEYS);
            pt.executeUpdate();

    }

    public void init(long idCarpeta) {
        id = idCarpeta;
    }
}
