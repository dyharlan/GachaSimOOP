package gachasimoop.Frontends;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//The fxml file which contains the layout for the JavaFX UI and the Controller is located in this directory.

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class contains the method to launch the JavaFX front-end.
 * The FXController handles application logic, while the fxml file handles the layout, to be edited by the Scene Builder.
 * @author dyhar
 */
public class WishSimFX extends Application {
    
    public static void fx() {
        launch();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("WishSimFX.fxml"));
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("ShitGacha/Frontend/flat.css";
        stage.setScene(scene);
        stage.setTitle("GachaSimOOP beta3");
        stage.setResizable(false);
        stage.show();
    }

   
}
