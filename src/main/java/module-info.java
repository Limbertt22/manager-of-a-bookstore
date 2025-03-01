module com.example.proyectfx1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;
    requires java.scripting;
    requires exp4j;

    opens com.example.proyectfx1 to javafx.fxml;
    exports com.example.proyectfx1;
}