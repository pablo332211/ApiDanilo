module com.example.apidanilo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.kordamp.bootstrapfx.core;
    requires com.jfoenix;

    opens com.example.apidanilo to javafx.fxml;
    exports com.example.apidanilo;
    exports com.example.apidanilo.Controller;
    opens com.example.apidanilo.Controller to javafx.fxml;
    exports com.example.apidanilo.Controller.ADMP;
    opens com.example.apidanilo.Controller.ADMP to javafx.fxml;
    opens com.example.apidanilo.Controller.ADMP.CarpetaDos to javafx.fxml;
    opens com.example.apidanilo.Controller.ADMP.CarpetaTres to javafx.fxml;
    opens com.example.apidanilo.Controller.ADMP.CarpetaCuatro to javafx.fxml;
    opens com.example.apidanilo.Controller.ADMP.CarpetaCinco to javafx.fxml;
    opens com.example.apidanilo.Dao to javafx.fxml;


}