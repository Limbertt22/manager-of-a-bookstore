package com.example.proyectfx1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class compraClientes {

    @FXML
    private TextArea registroClientes;

    @FXML
    private TextField clienteBuscar;

    @FXML
    private TextField elminarCliente;
    private static final HashMap<String, Integer> map = new HashMap<>();
    static {
        map.put("principito", 200);
    }
    int fila = 0;
    @FXML
    public void buscar() {
        String textArea = registroClientes.getText();
        String buscar = clienteBuscar.getText();
        int index = textArea.indexOf(buscar);
        String[] sout = textArea.split("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
        System.out.println(Arrays.toString(sout));

        if(!buscar.equals("Edad") && !buscar.equals("Nombre") && !buscar.equals("Libro") && !buscar.equals("Costo") && !buscar.contains("»")) {
            if (index != -1) {
                registroClientes.positionCaret(index);
            }
        }else{
            clienteBuscar.setText("no encontrado");
        }
    }
    public void initialize(){
        Random rd = new Random();
        int secosd = rd.nextInt(10,20);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(secosd), event -> {
           String[] usarios = {"Liam", "Emma", "Noah", "Olivia", "William", "Ava", "James", "Isabella", "Oliver", "Sophia",
                   "Benjamin", "Charlotte", "Elijah", "Amelia", "Lucas", "Mia", "Mason", "Harper", "Logan", "Evelyn",
                   "Alexander", "Abigail", "Ethan", "Ella", "Jacob", "Scarlett", "Michael", "Grace", "Daniel", "Lily",
                   "Henry", "Aria", "Jackson", "Chloe", "Sebastian", "Victoria"
           };
           fila++;
           names(usarios);
           initialize();
        }));
        timeline.play();
    }

    public void libroYimporte(){
        Random rd = new Random();
        int libro = rd.nextInt(map.size());
        int cont = 0;
        String value = "";

        for (String val: map.keySet()){
            if(cont == libro){
                value = val;
                break;
            }
            cont++;
        }

        registroClientes.appendText("Fila: "+fila+"\n");
        registroClientes.appendText("Libro: "+value+"\n");
        registroClientes.appendText("Costo: "+obtenerLibros().get(value).intValue()+"$"+"\n");
        registroClientes.appendText("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»\n");
    }

    public static void agregarLibro(String libro, int precio){
        map.put(libro, precio);
    }

    public static HashMap<String, Integer> obtenerLibros() {
        return map;
    }

    public static void borrarLibro(String name){
        map.remove(name);
    }

    public void edad(){
        Random edad = new Random();
        int edad1 = edad.nextInt(18,70);
        registroClientes.appendText("Edad: "+edad1+"\n");
        libroYimporte();
    }


    public void names(String[]nombres){
       Random rd= new Random();
       int nombre = rd.nextInt(0, nombres.length-1);
       int apellido = rd.nextInt(0, nombres.length-1);;
       int segundoApellido = rd.nextInt(0, nombres.length-1);

       String name = nombres[nombre]+" "+nombres[apellido]+" "+nombres[segundoApellido];
       registroClientes.appendText("Nombre: "+name+"\n");
       JOptionPane.showConfirmDialog(null,name+" a comprado un nuevo libro!");
       edad();
    }

    public void eliminar(){

        try {
            String textOrigin = registroClientes.getText();
            StringBuilder builder = new StringBuilder();
            int index = Integer.parseInt(elminarCliente.getText());
            String[] separador = textOrigin.split("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
            System.out.println(Arrays.toString(separador));

            for (int i = 0; i < separador.length; i++) {
                if (separador[i].length() > 4 && i != index-1){
                    builder.append(separador[i]);
                    System.out.println("info: "+separador[i]);
                    builder.append("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
                }
            }


            registroClientes.setText(builder.toString());
        } catch (Exception e) {
           elminarCliente.setText("usuario no existente");
        }
    }
}
