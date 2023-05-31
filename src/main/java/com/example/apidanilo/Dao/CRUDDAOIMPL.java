package com.example.apidanilo.Dao;

import com.example.apidanilo.Entity.carpeta_padre;
import com.example.apidanilo.Util.ConectionBD;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CRUDDAOIMPL {

   List<?> listAll() throws SQLException;
   void create(Object obj) throws SQLException;
   void delete(Object obj);
   void modify(Object obj) throws SQLException;


}
