package com.example.practica_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private HBox botones_salir;

    public void onConfirmButtonCLick(ActionEvent actionEvent) {
        //System.out.println("confirmo");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion");
        alert.setHeaderText(null);
        alert.setContentText("Desea comprar el boleto X con precio Y?");
        alert.showAndWait().ifPresent(response -> {
            if(response.equals(ButtonType.OK)){
                System.out.println("confirmacion");
            }else{
                System.out.println("no confirma");
            }
        });



    }

    public void onOtroAsientoButtonCLick(ActionEvent actionEvent) {
    }

    public void onOtroBoletoButtonClick(ActionEvent actionEvent) {
    }

    public void onSalirButtonClick(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botones_salir.setVisible(false);
    }
}