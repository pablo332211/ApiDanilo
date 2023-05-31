package com.example.apidanilo.Controller;


import com.example.apidanilo.Controller.ADMP.ControllerADMP;
import com.example.apidanilo.HelloApplication;
import com.example.apidanilo.Util.ConectionBD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {


    @FXML
    private TextField FieldDocumentoLogin;

    @FXML
    private PasswordField FieldPassLogin;

    @FXML
    private Button ButtonLogin;

    @FXML
    private Hyperlink HyperLogin;

    @FXML
    private TextField FieldDocumentoNameP;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }




    //METODOS FXML
    @FXML
    void ButtonLogin(ActionEvent event) throws SQLException, IOException {


        long Documento = Long.parseLong(FieldDocumentoLogin.getText().trim());
        String Password = FieldPassLogin.getText().trim();




        if (Password.equals("") && FieldDocumentoNameP.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("EROOR");
            alert.setContentText("Falta algun campo");
            alert.showAndWait();
        }else {


            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            connection = ConectionBD.connectionMYSQL();


            String Validar = "SELECT * FROM administrador_p WHERE Cedula_p = '" + Documento + "'AND Contrasena_p = '" + Password + "'";



            statement = connection.createStatement();
            resultSet= statement.executeQuery(Validar);

            if(resultSet.next()) {



                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/Home.fxml"));
                Parent root = fxmlLoader.load();

                ControllerADMP controllerADMP = fxmlLoader.getController();
                controllerADMP.sendName(Documento);


                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                Stage mystage = (Stage) this.ButtonLogin.getScene().getWindow();
                mystage.close();


            }else{

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("EROOR");
                alert.setContentText("No Registrado");
                alert.showAndWait();
            }

        }

    }



}
