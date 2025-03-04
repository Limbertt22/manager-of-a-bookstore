package com.example.proyectfx1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class SceneRoot extends Application {
    @Override
    //metodo para abrir la ventana root(principal)
    public void start(Stage stage) throws IOException {
        //cargar el archivo fxml(interfaz) a la escena
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/InterfaceMain.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            //aqui se agrega la hoja de estilo, se pone un titulo, se carga la escena a la estacion y se muestra el show!
            scene.getStylesheets().add(getClass().getResource("styleCss/Style-InterfaceMain.css").toExternalForm());
            stage.setTitle("BOOK'S and Controller");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //conectar con el start metodo y comenzar el proceso
        launch();
    }
}