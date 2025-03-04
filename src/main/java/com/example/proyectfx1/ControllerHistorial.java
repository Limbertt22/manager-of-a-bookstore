package com.example.proyectfx1;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerHistorial {
    @FXML
    public TextArea historical;
    @FXML
    public TextField Buscar;

    public void buscar(){
        try {
            String objetivo = historical.getText();
            String buscador = Buscar.getText();
            int index = objetivo.indexOf(buscador);

            if (index != -1) {
                historical.positionCaret(index);
            } else {

            }
        } catch (Exception e) {
            Buscar.setText("no encontramos nada");
        }
    }

    //funcion que conecta el TextArea y que ayudara a sere usada por externos!
    public void sethisto(String text){
        historical.appendText(text);
    }
}
