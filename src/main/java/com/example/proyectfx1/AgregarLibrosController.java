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

    //se llama la clase para ser utilizada la funcion
    private ControllerHistorial controllerHistorial;

    //metodo muy importante
    public void setControllerHistorial(ControllerHistorial controllerHistorial) {
        this.controllerHistorial = controllerHistorial;
    }


    public void aggregate(){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechahoy = fecha.format(date);
        if(!name.getText().isEmpty() && !costo.getText().isEmpty()){
            TextArea.appendText("Libro: "+name.getText()+"                                              "+fechahoy+"\n");
            TextArea.appendText("costo: "+costo.getText()+"\n");
            TextArea.appendText("___________________________________________________________________\n");
        }

        //mensaje o texto que se quiere dar
        controllerHistorial.sethisto("se agrego un libro llamado:"+name.getText()+" el "+fechahoy+"\n");
        controllerHistorial.sethisto("___________________________________________________________________\n");

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
