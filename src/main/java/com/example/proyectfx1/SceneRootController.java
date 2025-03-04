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
    private Label option3;

    @FXML
    private Label MADN;

    @FXML
    private Label servicios;

    @FXML
    private Label version;
    @FXML
    Button modulo2;
    protected int cont3 = 0, cont = 0, cont2 = 0;
    Stage escenario;
    Stage escenario4;
    Stage escenario2;
    Stage escenario3;
    Stage escenario5;;

    //controler de la otra clse
    private ControllerHistorial controllerHistorial;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    @FXML
    public void Ispressed() {
        option1.setOnMouseClicked(event -> {
            menu3.setVisible(false);
            if (cont == 0) {
                menu1.setVisible(true);
                cont = 1;
            } else {
                menu1.setVisible(false);
                cont = 0;
            }
        });

        option3.setOnMouseClicked(event -> {
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
            FXMLLoader folder = new FXMLLoader(getClass().getResource("fxml/historial.fxml"));
            Parent root = folder.load();
            root.getStylesheets().add(getClass().getResource("styleCss/Style8-Historial.css").toExternalForm());
            controllerHistorial = folder.getController();
            escenario4 = new Stage();
            escenario4.setTitle("historial");
            escenario4.setScene(new Scene(root, 700, 700));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try{
            FXMLLoader folder = new FXMLLoader(getClass().getResource("fxml/compraclientes.fxml"));
            Parent root = folder.load();
            root.getStylesheets().add(getClass().getResource("styleCss/Style4-CompraClientes.css").toExternalForm());
            compraClientes compraClientes = folder.getController();
            compraClientes.setControllerHistorial(controllerHistorial);
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
            ///gabriel de el futuro, se que se te va a olvidar asi que aqui te dejo la explicacion de como usar funciones
            /// en otras clases,

            /// aqui primero llamas el controler de tu ventana o fxml y extraes su controller
            AgregarLibrosController agregarLibrosController = folder.getController();

            ///aqui le pones el controler de la otra clase
            agregarLibrosController.setControllerHistorial(controllerHistorial);

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

    public void PressedButton3(){
        escenario4.show();
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

        version.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("fxml/Version.fxml"));
                Parent root1 = loader1.load();
                root1.getStylesheets().add(getClass().getResource("styleCss/Style7-version.css").toExternalForm());

                Stage stage1 = new Stage();
                stage1.setTitle("version");
                stage1.setScene(new Scene(root1, 700, 700));
                System.out.println("FXML cargado correctamente");
                stage1.show();
            } catch (Exception e) {
                System.out.println("");
            }
        });

    }
}