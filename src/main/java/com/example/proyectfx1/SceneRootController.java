package com.example.proyectfx1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class SceneRootController{
    @FXML
    private Button modulo1;

    @FXML
    private Button modulo3;

    @FXML
    private Label setHora;

    @FXML
    private VBox body;

    @FXML
    VBox menu1;

    @FXML
    private VBox menu2;

    @FXML
    private VBox menu3;

    @FXML
    private Label option1;

    @FXML
    private Label option2;

    @FXML
    private Label option3;

    @FXML
    private Label MADN;

    @FXML
    private Label servicios;

    @FXML
    Button modulo2;

    protected int cont3 = 0, cont = 0, cont2 = 0;
    Stage escenario;
    Stage escenario2;
    Stage escenario3;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @FXML
    public void Ispressed() {
        option1.setOnMouseClicked(event -> {
            menu2.setVisible(false);
            menu3.setVisible(false);
            if (cont == 0) {
                menu1.setVisible(true);
                cont = 1;
            } else {
                menu1.setVisible(false);
                cont = 0;
            }
        });

        option2.setOnMouseClicked(event -> {
            menu1.setVisible(false);
            menu3.setVisible(false);
            if (cont2 == 0) {
                menu2.setVisible(true);
                cont2 = 1;

            } else {
                menu2.setVisible(false);
                cont2 = 0;
            }
        });

        option3.setOnMouseClicked(event -> {
            menu2.setVisible(false);
            menu1.setVisible(false);

            if (cont3 == 0) {
                menu3.setVisible(true);
                cont3 = 1;

            } else {
                menu3.setVisible(false);
                cont3 = 0;
            }
        });
    }

    public void initialize() {

        try{
            FXMLLoader folder = new FXMLLoader(getClass().getResource("fxml/compraclientes.fxml"));
            Parent root = folder.load();
            root.getStylesheets().add(getClass().getResource("styleCss/Style4-CompraClientes.css").toExternalForm());
            escenario = new Stage();
            escenario.setTitle("compras clientes");
            escenario.setScene(new Scene(root, 700, 700));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try{
            FXMLLoader folder = new FXMLLoader(getClass().getResource("fxml/AgregarLibros.fxml"));
            Parent root = folder.load();
            root.getStylesheets().add(getClass().getResource("styleCss/Style5.css").toExternalForm());

            escenario2 = new Stage();
            escenario2.setTitle("agregar libros");
            escenario2.setScene(new Scene(root, 700,700));
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        try {
            Timeline Reloj = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                LocalTime LOCALTIME = LocalTime.now();
                setHora.setText("MX-" + LOCALTIME.format(formatter));
            }));
            Reloj.setCycleCount(Timeline.INDEFINITE);
            Reloj.play();
        }catch (Exception e){
            System.out.println("limpio");
        }

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/calculos.fxml"));
            Parent root = loader.load();
            root.getStylesheets().add(getClass().getResource("styleCss/Style6-Calculos.css").toExternalForm());

            escenario3 = new Stage();
            escenario3.setTitle("calculator");
            escenario3.setScene(new Scene(root, 700,700));
        }catch (Exception e){

        }

        PressedButtons();
    }

    public void PressedButtons(){
       modulo1.setOnAction(event ->{
           escenario.show();
       });

       modulo3.setOnAction(event ->{
           escenario3.show();
       });
    }

    public void PressedButton2(){
        escenario2.show();
    }

    public void Options() {
        MADN.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/menu-MoreAboutUs.fxml"));
                Parent root = loader.load();
                root.getStylesheets().add(getClass().getResource("styleCss/Style2-MoreAboutUs.css").toExternalForm());
                Stage stage = new Stage();
                stage.setTitle("mas de nosotros");
                stage.setScene(new Scene(root,700,700));
                System.out.println("FXML cargado correctamente");
                stage.show();
            } catch (Exception e) {
                System.out.println("");
            }
        });


        servicios.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("fxml/menu-Service.fxml"));
                Parent root1 = loader1.load();
                root1.getStylesheets().add(getClass().getResource("styleCss/Style3-Service.css").toExternalForm());

                Stage stage1 = new Stage();
                stage1.setTitle("servicios");
                stage1.setScene(new Scene(root1, 700, 700));
                System.out.println("FXML cargado correctamente");
                stage1.show();
            } catch (Exception e) {
                System.out.println("");
            }
        });


    }
}