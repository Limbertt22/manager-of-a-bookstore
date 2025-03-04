package com.example.proyectfx1;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class CalculosAndOperaciones {
    @FXML
    private TextField ventana;
    @FXML
    private Button numero0;
    @FXML
    private Button numero1;
    @FXML
    private Button numero2;
    @FXML
    private Button numero3;
    @FXML
    private Button numero4;
    @FXML
    private Button numero5;
    @FXML
    private Button numero6;
    @FXML
    private Button numero7;
    @FXML
    private Button numero8;
    @FXML
    private Button numero9;
    @FXML
    private Button numero10;
    @FXML
    private Button numero11;
    @FXML
    private Button numero12;
    @FXML
    private Button numero13;
    @FXML
    private Button numero14;
    @FXML
    private Button numero15;
    @FXML
    private Button numero16;
    @FXML
    private ComboBox monedas;
    @FXML
    private TextField monto;
    @FXML
    private TextArea textAREA;
    @FXML
    private ComboBox monedas1;
    @FXML
    private TextField monto1;
    @FXML
    private TextArea textAREA1;
    @FXML
    private Button numero17;
    @FXML
    private Button numero18;

    public void agregate(){
        numero0.setOnAction(event ->{
            ventana.appendText("0");
        });

        numero1.setOnAction(event->{
            ventana.appendText("1");
        });

        numero2.setOnAction(event->{
            ventana.appendText("2");
        });

        numero3.setOnAction(event->{
            ventana.appendText("3");
        });

        numero4.setOnAction(event->{
            ventana.appendText("4");
        });

        numero5.setOnAction(event->{
            ventana.appendText("5");
        });

        numero6.setOnAction(event->{
            ventana.appendText("6");
        });

        numero7.setOnAction(event->{
            ventana.appendText("7");
        });

        numero8.setOnAction(event->{
            ventana.appendText("8");
        });

        numero9.setOnAction(event->{
            ventana.appendText("9");
        });

        numero10.setOnAction(event->{
            ventana.appendText("+");
        });

        numero11.setOnAction(event->{
            ventana.appendText("-");
        });

        numero12.setOnAction(event->{
            ventana.appendText("(");
        });

        numero13.setOnAction(event->{
            ventana.appendText(")");
        });

        numero14.setOnAction(event->{
            ventana.appendText("/");
        });

        numero15.setOnAction(event->{
            ventana.appendText(".");
        });

        numero16.setOnAction(event->{
            ventana.appendText("x");
        });

        numero17.setOnAction(event ->{
            ventana.setText("");
        });

        numero18.setOnAction(event ->{
            operacion();
        });
    }

    public void operacion(){
        try {
            String val = ventana.getText();
            Expression expresion = new ExpressionBuilder(val).build();
            double result = expresion.evaluate();
            ventana.setText(String.valueOf(result));
        } catch (Exception e) {
            ventana.setText("SYNTAX ERROR");
        }
    }

    public void convercion(){
        try {
            String val = monedas.getValue().toString();
            if (val.equals("dolar")) {
                double Dolar = 20.55;
                double valor = Double.parseDouble(monto.getText())*Dolar;
                textAREA.setText(String.valueOf(valor)+" pesos");
            }

            if (val.equals("euro")) {
                double euro = 21.31 ;
                double valor = Double.parseDouble(monto.getText())*euro;
                textAREA.setText(String.valueOf(valor)+"pesos");
            }

            if (val.equals("yen")) {
                double euro = 0.14 ;
                double valor = Double.parseDouble(monto.getText())*euro;
                textAREA.setText(String.valueOf(valor)+"pesos");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void convercion1(){
        try {
            String val = monedas1.getValue().toString();
            if (val.equals("dolar")) {
                double Dolar = 0.049;
                double valor = Double.parseDouble(monto1.getText())*Dolar;
                textAREA1.setText(String.valueOf(valor)+"dolares");
            }

            if (val.equals("euro")) {
                double euro = 21.31 ;
                double valor = Double.parseDouble(monto1.getText())*euro;
                textAREA1.setText(String.valueOf(valor)+"euros");
            }

            if (val.equals("yen")) {
                double euro = 0.14 ;
                double valor = Double.parseDouble(monto1.getText())*euro;
                textAREA1.setText(String.valueOf(valor)+"yenes");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
