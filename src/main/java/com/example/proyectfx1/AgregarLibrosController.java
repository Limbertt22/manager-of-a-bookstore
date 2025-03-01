package com.example.proyectfx1;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AgregarLibrosController {
    @FXML
    protected TextArea TextArea;
    @FXML
    protected TextField name;
    @FXML
    protected TextField costo;
    @FXML
    protected TextField nameB;

    protected LocalDate fecha = LocalDate.now();

    public void aggregate(){
        if(!name.getText().isEmpty() && !costo.getText().isEmpty()){
            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yy");
            String fechahoy = fecha.format(date);
            TextArea.appendText("Libro: "+name.getText()+"                                              "+fechahoy+"\n");
            TextArea.appendText("costo: "+costo.getText()+"\n");
            TextArea.appendText("___________________________________________________________________\n");
        }
        compraClientes.agregarLibro(name.getText(), Integer.parseInt(costo.getText()));
    }

    public void borrarLibro(){
        String[] text = TextArea.getText().split("___________________________________________________________________");
        StringBuilder builder = new StringBuilder();
        TextArea.setText("");

        for(String b:text) {
            if (!b.contains(nameB.getText()) && b.length() > 4) {
                builder.append(b);
                builder.append("___________________________________________________________________\n");
            }
        }

        compraClientes.borrarLibro(nameB.getText());
        TextArea.setText(builder.toString());
    }
}
