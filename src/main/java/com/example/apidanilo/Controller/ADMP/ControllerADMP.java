package com.example.apidanilo.Controller.ADMP;

import com.example.apidanilo.Controller.ADMP.CarpetaCinco.ControllerAddFolderCinco;
import com.example.apidanilo.Controller.ADMP.CarpetaCinco.ControllerModifyRaizCinco;
import com.example.apidanilo.Controller.ADMP.CarpetaCuatro.ControllerAddFolderCuatro;
import com.example.apidanilo.Controller.ADMP.CarpetaCuatro.ControllerModifyRaizCuatro;
import com.example.apidanilo.Controller.ADMP.CarpetaDos.ControllerAddFolderDos;
import com.example.apidanilo.Controller.ADMP.CarpetaDos.ControllerModifyRaizDos;
import com.example.apidanilo.Controller.ADMP.CarpetaTres.ControllerAddFolderTres;
import com.example.apidanilo.Controller.ADMP.CarpetaTres.ControllerModifyRaizTres;
import com.example.apidanilo.Dao.carpeta_padreDAO;
import com.example.apidanilo.Entity.*;
import com.example.apidanilo.HelloApplication;
import com.example.apidanilo.Util.ConectionBD;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerADMP implements Initializable {


    private long DocumentoP;

    private administrador_p AdmP;

    ObservableList<administrador_p> Administrador_p = FXCollections.observableArrayList();



//BNT MISMA INTERFAZ PRINCIPAL UNO

    @FXML
    private Label NombreADMS;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlOverview;

    @FXML
    private VBox pnItems;



//PANE UNO

    @FXML
    private TableView<carpeta_padre> folderRaiz;

    @FXML
    private TableColumn<carpeta_padre, String> nombreRaiz;

    @FXML
    private TableColumn<carpeta_padre, String> descripcionRaiz;

    @FXML
    private TableColumn<carpeta_padre, Long> idCarpeta;

    //INGRESA A PANE CARPETA DOS
    @FXML
    private Button btnIngresar;




//PANE DOS

    //MUESTRA PANEL CARPETA DOS
    @FXML
    public Pane pnlIngresarSDos;

    @FXML
    private VBox pnItemsDos;

    @FXML
    private TableView<Subcarpetas_padreuno> folderRaizDos;

    @FXML
    private TableColumn<Subcarpetas_padreuno, String> nombreRaizDos;

    @FXML
    private TableColumn<Subcarpetas_padreuno, String> descripcionRaizDos;

    @FXML
    private TableColumn<Subcarpetas_padreuno, Long> idCarpetaDos;


    @FXML
    private TableColumn<Subcarpetas_padreuno, String> idCarpetaU;

    @FXML
    private TableColumn<Subcarpetas_padreuno, Long> idDatosCargados;


    //INGRESA A PANE TRES
    @FXML
    private Button btnIngresarDos;

    //MUESTRA NOMBRE DE CARPETA LLAMADA
    @FXML
    private Label nombreDos;


//PANE TRES

    //MUESTRA PANE TRES
    @FXML
    public Pane pnlIngresarSTres;

    @FXML
    private VBox pnItemsTres;

    @FXML
    private TableView<Subcarpeta_padredos> folderRaizTres;

    @FXML
    private TableColumn<Subcarpeta_padredos, String> nombreRaizTres;

    @FXML
    private TableColumn<Subcarpeta_padredos, String> descripcionRaizTres;

    @FXML
    private TableColumn<Subcarpeta_padredos, Long> idCarpetaTres;

    @FXML
    private TableColumn<Subcarpeta_padredos, Long> idCarpetaDosFK;


    //INGRESA A PANE CUATRO
    @FXML
    private Button btnIngresarTres;

    @FXML
    private Label nombreTres;

//PANE CUATRO

    //MUESTRA PANE CUATRO
    @FXML
    public Pane pnlIngresarSCuatro;

    @FXML
    private Label nombreCuatro;

    @FXML
    private VBox pnItemsCuatro;

    @FXML
    private TableView<Subcarpeta_padretres> folderRaizCuatro;

    @FXML
    private TableColumn<Subcarpeta_padretres, String> nombreRaizCuatro;

    @FXML
    private TableColumn<Subcarpeta_padretres, String> descripcionRaizCuatro;

    //INGRESA A PANE CINCO
    @FXML
    private TableColumn<Subcarpeta_padretres, Long> idCarpetaCuatro;

    @FXML
    public TableColumn <Subcarpeta_padretres, Long> idCarpetaTresFK;

    @FXML
    private Button btnIngresarCuatro;


    //PANE CINCO

    //MUESTRA PANE CUATRO
    @FXML
    private Pane pnlIngresarSCinco;

    @FXML
    private Label nombreCinco;

    @FXML
    private VBox pnItemsCinco;

    @FXML
    private TableView<Subcarpeta_padrecuatro> folderRaizCinco;

    @FXML
    private TableColumn<Subcarpeta_padrecuatro, String> nombreRaizCinco;

    @FXML
    private TableColumn<Subcarpeta_padrecuatro, String> descripcionRaizCinco;

    @FXML
    private TableColumn<Subcarpeta_padrecuatro, Long> idCarpetaCinco;

    @FXML
    private TableColumn<Subcarpeta_padrecuatro, Long> idCarpetaCuantroFK;

    @FXML
    private Button btnIngresarCinco;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            loadDate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//METODOS FXML UNO
    //EVENTO PARA MOSTRAR VENTANA DE AGREGAR
    @FXML
    void getAddView(MouseEvent event) throws IOException, SQLException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/AddFolderRaiz.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

    }

    @FXML
    public void refreshRaiz(MouseEvent event) throws SQLException {

        //instancio carpeta dao para llamar informacion y acceder al metodo
        loadDate();
    }

    //Enviar datos a modificar
    @FXML
    void modifyRaiz(MouseEvent event) throws IOException, SQLException {

        carpeta_padre c = this.folderRaiz.getSelectionModel().getSelectedItem();

        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una carpeta");
            alert.showAndWait();
        } else {
            try {
                //cargo la vista
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/Modify.fxml"));

                // Cargo la ventana
                Parent root = fxmlLoader.load();

                // Cojo el controlador
                ControllerModifyRaiz controllerModifyRaiz = fxmlLoader.getController();
                controllerModifyRaiz.initAttributtes(c.getIdCarpeta(), c.getTitulo(), c.getDescripcion_padre());



                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();

                // cojo la persona devuelta
                carpeta_padre aux = controllerModifyRaiz.getPersona();
                if (aux != null) {
                    this.folderRaiz.refresh();
                }

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        }
    }


    @FXML
    void deleteRaiz(MouseEvent event) throws SQLException {

            carpeta_padre Carpeta_padre = this.folderRaiz.getSelectionModel().getSelectedItem();
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            connection = ConectionBD.connectionMYSQL();

            String queryDelete = "DELETE FROM `carpeta_padre` WHERE idCarpeta  =" + Carpeta_padre.getIdCarpeta();

            preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.execute();

           loadDate();
    }


//METODOS CREADOS UNO
    //METODO PARA CARGAR DATOS EN LA TABLA BASE DE DATOS
    public void loadDate() throws SQLException {

       //instancio carpeta dao para llamar informacion y acceder al metodo
       carpeta_padreDAO Carpeta_padreDAO = new carpeta_padreDAO();
       Carpeta_padreDAO.listAll();

       sendName(DocumentoP);
       nombreRaiz.setCellValueFactory(param -> param.getValue().tituloProperty());
       descripcionRaiz.setCellValueFactory(param -> param.getValue().descripcion_padreProperty());

       //seteo informacion
       folderRaiz.setItems((ObservableList<carpeta_padre>) Carpeta_padreDAO.listAll());
    }




//METODOS FXMLDOS


    @FXML
    void getAddViewDos(MouseEvent event) throws IOException {

        carpeta_padre c = this.folderRaiz.getSelectionModel().getSelectedItem();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/VistaCarpetaDos/AddFolderDos.fxml"));
        Parent root = fxmlLoader.load();

        ControllerAddFolderDos controllerAddFolderDos = fxmlLoader.getController();
        controllerAddFolderDos.init(c.getIdCarpeta());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();


    }

    @FXML
    void modifyRaizDos(MouseEvent event) {


        carpeta_padre cuno = this.folderRaiz.getSelectionModel().getSelectedItem();
        Subcarpetas_padreuno c = this.folderRaizDos.getSelectionModel().getSelectedItem();


        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una carpeta");
            alert.showAndWait();
        } else {
            try {
                //cargo la vista
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/VistaCarpetaDos/ModifyDos.fxml"));

                // Cargo la ventana
                Parent root = fxmlLoader.load();

                // Cojo el controlador
                ControllerModifyRaizDos controllerModifyRaizDos = fxmlLoader.getController();
                controllerModifyRaizDos.initAttributtesDos(c.getIdSubcarpeta_padreUno(), c.getNombre_padreUno(), c.getDescripcion_padreUno(), cuno.getIdCarpeta());


                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();

                // cojo la persona devuelta

                Subcarpetas_padreuno aux = controllerModifyRaizDos.getSubUno();

                if (aux != null) {
                    this.folderRaizDos.refresh();
                }

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        }



    }

    @FXML
    void refreshRaizDos(MouseEvent event) throws SQLException {

        subcarpetas_padreunoListas();

    }

    @FXML
    void deleteRaizDos(MouseEvent event) throws SQLException {

        carpeta_padre Carpeta_padre = this.folderRaiz.getSelectionModel().getSelectedItem();
        Subcarpetas_padreuno subcarpetas_padreuno = this.folderRaizDos.getSelectionModel().getSelectedItem();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = ConectionBD.connectionMYSQL();

        String queryDelete = " DELETE FROM `subcarpetas_padreuno` WHERE `idSubcarpeta_padreUno` = '"+subcarpetas_padreuno.getIdSubcarpeta_padreUno()+"' AND `Carpeta_Padre_idCarpeta` = '"+subcarpetas_padreuno.getCarpeta_Padre_idCarpeta()+"' AND `Datos_Cargados_E` = 1";

        preparedStatement = connection.prepareStatement(queryDelete);
        preparedStatement.execute();
        subcarpetas_padreunoListas();



    }


//METODOS CREADOS DOS
    //METODO PARA CARGAR DATOS EN LA TABLA BASE DE DATOS 2
    public void loadDatesubcarpetas_padreuno() throws SQLException {

        subcarpetas_padreunoListas();
        nombreRaizDos.setCellValueFactory(param -> param.getValue().nombre_padreUnoProperty());
        descripcionRaizDos.setCellValueFactory(param -> param.getValue().descripcion_padreUnoProperty());



    }

    //METODO llamar PARA LISTAR CON BASE DED DATOS 1
    public List<Subcarpetas_padreuno> subcarpetas_padreunoListas() throws SQLException {

        carpeta_padre Carpeta_padre = this.folderRaiz.getSelectionModel().getSelectedItem();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = ConectionBD.connectionMYSQL();
        Subcarpetas_padreuno subcarpetas_padreuno = null;
        ObservableList<Subcarpetas_padreuno> subcarpetas_padreunosList = FXCollections.observableArrayList();
        ObjectProperty<Subcarpetas_padreuno> objSubcarpetas_padre = new SimpleObjectProperty<>();



        String date = "SELECT s.idSubcarpeta_padreUno, s.Nombre_padreUno, s.Descripcion_padreUno, s.Carpeta_Padre_idCarpeta, c.idCarpeta FROM subcarpetas_padreuno s INNER JOIN carpeta_padre c ON s.Carpeta_Padre_idCarpeta = c.idCarpeta where Carpeta_Padre_idCarpeta = '"+Carpeta_padre.getIdCarpeta()+"'";

        statement = connection.createStatement();
        resultSet = statement.executeQuery(date);

        while (resultSet.next()){


            subcarpetas_padreuno = new Subcarpetas_padreuno();
            subcarpetas_padreuno.setNombre_padreUno(resultSet.getString("Nombre_padreUno"));
            subcarpetas_padreuno.setDescripcion_padreUno(resultSet.getString("Descripcion_padreUno"));
            subcarpetas_padreuno.setIdSubcarpeta_padreUno(resultSet.getLong("idSubcarpeta_padreUno"));
            subcarpetas_padreuno.setCarpeta_Padre_idCarpeta(resultSet.getLong("Carpeta_Padre_idCarpeta"));

            Carpeta_padre.getIdCarpeta();



            subcarpetas_padreunosList.add(subcarpetas_padreuno);
            folderRaizDos.setItems(subcarpetas_padreunosList);
        }

        return subcarpetas_padreunosList;

    }


//METODOS FXML TRES

    @FXML
    void deleteRaizTres(MouseEvent event) throws SQLException {

        Subcarpetas_padreuno subcarpetas_padreuno = this.folderRaizDos.getSelectionModel().getSelectedItem();
        Subcarpeta_padredos subcarpeta_padredos = this.folderRaizTres.getSelectionModel().getSelectedItem();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = ConectionBD.connectionMYSQL();

        String queryDelete = "DELETE FROM `subcarpeta_padredos` WHERE `idSubcarpeta_padreDos` = '"+subcarpeta_padredos.getIdSubcarpeta_padreDos()+"' AND `SubCarpetas_padreUno` = '"+subcarpetas_padreuno.getIdSubcarpeta_padreUno()+"'";

        System.out.println(queryDelete);
        preparedStatement = connection.prepareStatement(queryDelete);
        preparedStatement.execute();
        subcarpetas_padredosListas();

    }


    @FXML
    void getAddViewTres(MouseEvent event) throws IOException {

        Subcarpetas_padreuno c = this.folderRaizDos.getSelectionModel().getSelectedItem();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/VistaCarpetaTres/AddFolderTres.fxml"));
        Parent root = fxmlLoader.load();

        ControllerAddFolderTres controllerAddFolderTres = fxmlLoader.getController();
        controllerAddFolderTres.init(c.getIdSubcarpeta_padreUno());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

    }


    @FXML
    void modifyRaizTres(MouseEvent event) {


        Subcarpeta_padredos c = this.folderRaizTres.getSelectionModel().getSelectedItem();
        Subcarpetas_padreuno cuno = this.folderRaizDos.getSelectionModel().getSelectedItem();


        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una carpeta");
            alert.showAndWait();
        } else {
            try {
                //cargo la vista
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/VistaCarpetaTres/ModifyTres.fxml"));

                // Cargo la ventana
                Parent root = fxmlLoader.load();

                // Cojo el controlador
                ControllerModifyRaizTres controllerModifyRaizTres = fxmlLoader.getController();
                controllerModifyRaizTres.initAttributtesTres(c.getIdSubcarpeta_padreDos(), c.getNombre_padreDos(), c.getDescripcion_padreDos(), cuno.getIdSubcarpeta_padreUno());


                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();

                // cojo la persona devuelta

                Subcarpeta_padredos aux = controllerModifyRaizTres.getSubDos();

                if (aux != null) {
                    this.folderRaizTres.refresh();
                }

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        }




    }

    @FXML
    void refreshRaizTres(MouseEvent event) throws SQLException {

        subcarpetas_padredosListas();

    }


//METODOS CREADOS TRES

    //METODO PARA CARGAR DATOS EN LA TABLA BASE DE DATOS 3
    public void loadDatesubcarpetas_padredos() throws SQLException {

        subcarpetas_padredosListas();
        nombreRaizTres.setCellValueFactory(param -> param.getValue().nombre_padreDosProperty());
        descripcionRaizTres.setCellValueFactory(param -> param.getValue().descripcion_padreDosProperty());



    }

    //METODO llamar PARA LISTAR CON BASE DED DATOS 3
    public List<Subcarpeta_padredos> subcarpetas_padredosListas() throws SQLException {

        Subcarpetas_padreuno subcarpetas_padreuno = this.folderRaizDos.getSelectionModel().getSelectedItem();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = ConectionBD.connectionMYSQL();
        Subcarpeta_padredos subcarpeta_padredos = null;
        ObservableList<Subcarpeta_padredos> subcarpeta_padredosList = FXCollections.observableArrayList();
        ObjectProperty<Subcarpeta_padredos> objSubcarpetas_dos = new SimpleObjectProperty<>();



        String date = "SELECT sd.idSubcarpeta_padreDos, sd.Nombre_padreDos, sd.Descripcion_padreDos, sd.SubCarpetas_padreuno, su.idSubcarpeta_padreUno FROM subcarpeta_padredos sd INNER JOIN SubCarpetas_padreUno su ON sd.SubCarpetas_padreUno = su.idSubcarpeta_padreUno where SubCarpetas_padreUno = '"+subcarpetas_padreuno.getIdSubcarpeta_padreUno()+"'";

        statement = connection.createStatement();
        resultSet = statement.executeQuery(date);

        while (resultSet.next()){

            subcarpeta_padredos = new Subcarpeta_padredos();



            subcarpeta_padredos.setNombre_padreDos(resultSet.getString("Nombre_padreDos"));
            subcarpeta_padredos.setDescripcion_padreDos(resultSet.getString("Descripcion_padreDos"));
            subcarpeta_padredos.setIdSubcarpeta_padreDos(resultSet.getLong("idSubcarpeta_padreDos"));
            subcarpeta_padredos.setSubCarpetas_padreUno(resultSet.getLong("SubCarpetas_padreUno"));

            subcarpetas_padreuno.getIdSubcarpeta_padreUno();



            subcarpeta_padredosList.add(subcarpeta_padredos);
            folderRaizTres.setItems(subcarpeta_padredosList);
        }

        return subcarpeta_padredosList;

    }


//METODOS FXML CUATRO


    @FXML
    void getAddViewCuatro(MouseEvent event) throws IOException {

        Subcarpeta_padredos c = this.folderRaizTres.getSelectionModel().getSelectedItem();
        System.out.println(c.getIdSubcarpeta_padreDos());

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/VistaCarpetaCuatro/AddFolderCuatro.fxml"));
        Parent root = fxmlLoader.load();

        ControllerAddFolderCuatro controllerAddFolderCuatro = fxmlLoader.getController();
        controllerAddFolderCuatro.init(c.getIdSubcarpeta_padreDos());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

    }

    @FXML
    void refreshRaizCuatro(MouseEvent event) throws SQLException {

        loadDatesubcarpetas_padretres();

    }

    @FXML
    void modifyRaizCuatro(MouseEvent event) {

        Subcarpeta_padretres c = this.folderRaizCuatro.getSelectionModel().getSelectedItem();
        Subcarpeta_padredos cuno = this.folderRaizTres.getSelectionModel().getSelectedItem();


        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una carpeta");
            alert.showAndWait();
        } else {
            try {
                //cargo la vista
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/VistaCarpetaCuatro/ModifyCuatro.fxml"));

                // Cargo la ventana
                Parent root = fxmlLoader.load();

                // Cojo el controlador
                ControllerModifyRaizCuatro controllerModifyRaizCuatro = fxmlLoader.getController();
                controllerModifyRaizCuatro.initAttributtesCuatro(c.getIdSubcarpeta_padreTres(), c.getNombre_padreTres(), c.getDescripcion_padreTres(), cuno.getIdSubcarpeta_padreDos());


                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();

                // cojo la persona devuelta

                Subcarpeta_padretres aux = controllerModifyRaizCuatro.getSubTres();

                if (aux != null) {
                    this.folderRaizCuatro.refresh();
                }

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        }


    }



    @FXML
    void deleteRaizCuatro(MouseEvent event) throws SQLException {

        Subcarpeta_padredos subcarpetas_padredos = this.folderRaizTres.getSelectionModel().getSelectedItem();
        Subcarpeta_padretres subcarpeta_padretres = this.folderRaizCuatro.getSelectionModel().getSelectedItem();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = ConectionBD.connectionMYSQL();

        String queryDelete = "DELETE FROM `subcarpeta_padretres` WHERE `idSubcarpeta_padreTres` = '"+subcarpeta_padretres.getIdSubcarpeta_padreTres()+"' AND `idSubcarpeta_padreDos` = '"+subcarpetas_padredos.getIdSubcarpeta_padreDos()+"'";

        preparedStatement = connection.prepareStatement(queryDelete);
        preparedStatement.execute();
        subcarpetas_padretresListas();

    }





//METODOS CREADOS CUATRO

    //METODO PARA CARGAR DATOS EN LA TABLA BASE DE DATOS 4
    public void loadDatesubcarpetas_padretres() throws SQLException {

        subcarpetas_padretresListas();
        nombreRaizCuatro.setCellValueFactory(param -> param.getValue().nombre_padreTresProperty());
        descripcionRaizCuatro.setCellValueFactory(param -> param.getValue().descripcion_padreTresProperty());



    }


    //METODO llamar PARA LISTAR CON BASE DED DATOS 4

    public List<Subcarpeta_padretres> subcarpetas_padretresListas() throws SQLException {



        Subcarpeta_padredos subcarpetas_padredos = this.folderRaizTres.getSelectionModel().getSelectedItem();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = ConectionBD.connectionMYSQL();
        Subcarpeta_padretres subcarpeta_padretres = null;
        ObservableList<Subcarpeta_padretres> subcarpeta_padretresList = FXCollections.observableArrayList();
        ObjectProperty<Subcarpeta_padretres> objSubcarpetas_tres = new SimpleObjectProperty<>();


        String date = "SELECT st.idSubcarpeta_padreTres, st.Nombre_padreTres, st.Descripcion_padreTres, st.idSubCarpeta_padreDos, sd.idSubcarpeta_padreDos FROM subcarpeta_padretres st INNER JOIN SubCarpeta_padredos sd ON st.idSubCarpeta_padredos = sd.idSubcarpeta_padredos where st.idSubCarpeta_padredos = '"+ subcarpetas_padredos.getIdSubcarpeta_padreDos()+"'";




        statement = connection.createStatement();
        resultSet = statement.executeQuery(date);

        while (resultSet.next()){

            subcarpeta_padretres = new Subcarpeta_padretres();



            subcarpeta_padretres.setNombre_padreTres(resultSet.getString("Nombre_padreTres"));
            subcarpeta_padretres.setDescripcion_padreTres(resultSet.getString("Descripcion_padreTres"));
            subcarpeta_padretres.setIdSubcarpeta_padreTres(resultSet.getLong("idSubcarpeta_padreTres"));
            subcarpeta_padretres.setIdSubcarpeta_padreDos(resultSet.getLong("idSubCarpeta_padreDos"));

            subcarpetas_padredos.getIdSubcarpeta_padreDos();



            subcarpeta_padretresList.add(subcarpeta_padretres);
            folderRaizCuatro.setItems(subcarpeta_padretresList);
        }

        return subcarpeta_padretresList;







    }


//METODOS FXML CINCO


    @FXML
    void deleteRaizCinco(MouseEvent event) throws SQLException {

        Subcarpeta_padretres subcarpetas_padreTres = this.folderRaizCuatro.getSelectionModel().getSelectedItem();
        Subcarpeta_padrecuatro subcarpeta_padreCuatro = this.folderRaizCinco.getSelectionModel().getSelectedItem();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = ConectionBD.connectionMYSQL();

        String queryDelete = "DELETE FROM `subcarpeta_padrecuatro` WHERE `idSubcarpeta_padreCuatro` = '"+subcarpeta_padreCuatro.getIdSubcarpeta_padreCuatro()+"' AND `Subcarpeta_padreTres_idSubcarpeta_padreTres` = '"+subcarpetas_padreTres.getIdSubcarpeta_padreTres()+"'";


        preparedStatement = connection.prepareStatement(queryDelete);
        preparedStatement.execute();
        loadDatesubcarpetas_padrecuatro();

    }

    @FXML
    void getAddViewCinco(MouseEvent event) throws IOException {

        Subcarpeta_padretres c = this.folderRaizCuatro.getSelectionModel().getSelectedItem();


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/VistaCarpetaCinco/AddFolderCinco.fxml"));
        Parent root = fxmlLoader.load();

        ControllerAddFolderCinco controllerAddFolderCinco = fxmlLoader.getController();
        controllerAddFolderCinco.init(c.getIdSubcarpeta_padreTres());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();


    }

    @FXML
    void modifyRaizCinco(MouseEvent event) {

        Subcarpeta_padrecuatro c = this.folderRaizCinco.getSelectionModel().getSelectedItem();
        Subcarpeta_padretres cuno = this.folderRaizCuatro.getSelectionModel().getSelectedItem();


        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una carpeta");
            alert.showAndWait();
        } else {
            try {
                //cargo la vista
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaADMP/VistaCarpetaCinco/ModifyCinco.fxml"));

                // Cargo la ventana
                Parent root = fxmlLoader.load();

                // Cojo el controlador
                ControllerModifyRaizCinco controllerModifyRaizCinco = fxmlLoader.getController();
                controllerModifyRaizCinco.initAttributtesCinco(c.getIdSubcarpeta_padreCuatro(), c.getNombre_padreCuatro(), c.getDescripcion_padreCuatro(), cuno.getIdSubcarpeta_padreTres());


                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();

                // cojo la persona devuelta

                Subcarpeta_padrecuatro aux = controllerModifyRaizCinco.getSubCuatro();

                if (aux != null) {
                    this.folderRaizCinco.refresh();
                }

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        }

    }

    @FXML
    void refreshRaizCinco(MouseEvent event) throws SQLException {

        subcarpetas_padrecuatroListas();

    }



//METODOS CREADOS CINCO



    public void loadDatesubcarpetas_padrecuatro() throws SQLException {

        subcarpetas_padrecuatroListas();
        nombreRaizCinco.setCellValueFactory(param -> param.getValue().nombre_padreCuatroProperty());
        descripcionRaizCinco.setCellValueFactory(param -> param.getValue().descripcion_padreCuatroProperty());



    }


    //METODO llamar PARA LISTAR CON BASE DED DATOS 5

    public List<Subcarpeta_padrecuatro> subcarpetas_padrecuatroListas() throws SQLException {



        Subcarpeta_padretres subcarpetas_padretres = this.folderRaizCuatro.getSelectionModel().getSelectedItem();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = ConectionBD.connectionMYSQL();
        Subcarpeta_padrecuatro subcarpeta_padrecuatro = null;
        ObservableList<Subcarpeta_padrecuatro> subcarpeta_padrecuatroList = FXCollections.observableArrayList();
        ObjectProperty<Subcarpeta_padrecuatro> objSubcarpetas_cuatro = new SimpleObjectProperty<>();


        String date = "SELECT sc.idSubcarpeta_padreCuatro, sc.Nombre_padreCuatro, sc.Descripcion_padreCuatro, sc.Subcarpeta_padreTres_idSubcarpeta_padreTres, st.idSubcarpeta_padreTres FROM subcarpeta_padrecuatro sc INNER JOIN SubCarpeta_padretres st ON sc.Subcarpeta_padreTres_idSubcarpeta_padreTres = st.idSubcarpeta_padreTres where sc.Subcarpeta_padreTres_idSubcarpeta_padreTres = '"+ subcarpetas_padretres.getIdSubcarpeta_padreTres()+"'";



        statement = connection.createStatement();
        resultSet = statement.executeQuery(date);

        while (resultSet.next()){

            subcarpeta_padrecuatro = new Subcarpeta_padrecuatro();



            subcarpeta_padrecuatro.setNombre_padreCuatro(resultSet.getString("Nombre_padreCuatro"));
            subcarpeta_padrecuatro.setDescripcion_padreCuatro(resultSet.getString("Descripcion_padreCuatro"));
            subcarpeta_padrecuatro.setIdSubcarpeta_padreCuatro(resultSet.getLong("idSubcarpeta_padreCuatro"));
            subcarpeta_padrecuatro.setSubcarpeta_padreTres_idSubcarpeta_padreTres(resultSet.getLong("Subcarpeta_padreTres_idSubcarpeta_padreTres"));

            subcarpetas_padretres.getIdSubcarpeta_padreTres();



            subcarpeta_padrecuatroList.add(subcarpeta_padrecuatro);
            folderRaizCinco.setItems(subcarpeta_padrecuatroList);
        }

        return subcarpeta_padrecuatroList;







    }






    //METODOS Aparte





//CAMBIOS DE PANE
    public void handleClicks(ActionEvent actionEvent) throws SQLException {

    //EVENTO CARGA PANE DOS
        if(actionEvent.getSource() == btnIngresar){

            carpeta_padre c = this.folderRaiz.getSelectionModel().getSelectedItem();

            if (c == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debes seleccionar una Carpeta");
                alert.showAndWait();
            }else{


                pnlIngresarSDos.setStyle("-fx-background-color : #02030A");
                pnlIngresarSDos.toFront();
                nombreDos.setText(c.getTitulo());

                loadDatesubcarpetas_padreuno();

            }
        }

    //EVENTO CARGA PANE TRES
        if(actionEvent.getSource() == btnIngresarDos){

           Subcarpetas_padreuno c = this.folderRaizDos.getSelectionModel().getSelectedItem();


            if (c == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debes seleccionar una Carpeta");
                alert.showAndWait();
            }else{

                pnlIngresarSTres.setStyle("-fx-background-color : #02030A");
                pnlIngresarSTres.toFront();
                nombreTres.setText(c.getNombre_padreUno());

               loadDatesubcarpetas_padredos();

            }

        }

        //EVENTO CARGA PANE CUATRO
        if(actionEvent.getSource() == btnIngresarTres){

            Subcarpeta_padredos c = this.folderRaizTres.getSelectionModel().getSelectedItem();

            if (c == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debes seleccionar una Carpeta");
                alert.showAndWait();
            }else{

                pnlIngresarSCuatro.setStyle("-fx-background-color : #02030A");
                pnlIngresarSCuatro.toFront();
                nombreCuatro.setText(c.getNombre_padreDos());


                loadDatesubcarpetas_padretres();

            }

        }

        if (actionEvent.getSource() == btnIngresarCuatro){

            Subcarpeta_padretres c = this.folderRaizCuatro.getSelectionModel().getSelectedItem();

            if(c == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debes seleccionar una Carpeta");
                alert.showAndWait();
            }else {
                pnlIngresarSCinco.setStyle("-fx-background-color : #02030A");
                pnlIngresarSCinco.toFront();
                nombreCinco.setText(c.getDescripcion_padreTres());
                loadDatesubcarpetas_padrecuatro();

            }

        }


    }

    public void loadDatename() throws SQLException {


        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = ConectionBD.connectionMYSQL();
        administrador_p Administrador = null;

        sendName(DocumentoP);



        String date = "SELECT * FROM  administrador_p WHERE Cedula_p = '"+DocumentoP+ "'";





        statement = connection.createStatement();
        resultSet = statement.executeQuery(date);

        while (resultSet.next()){
            Administrador = new administrador_p();
            NombreADMS.setText(Administrador.setNombre_P(resultSet.getString("Nombre_P")));

        }

    }


    public void sendName(long documento) throws SQLException {

        DocumentoP = documento;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = ConectionBD.connectionMYSQL();
        administrador_p Administrador = null;

        String date = "SELECT * FROM  administrador_p WHERE Cedula_p = '"+DocumentoP+ "'";





        statement = connection.createStatement();
        resultSet = statement.executeQuery(date);

        while (resultSet.next()){
            Administrador = new administrador_p();
            NombreADMS.setText(Administrador.setNombre_P(resultSet.getString("Nombre_P")));

        }

    }
}

