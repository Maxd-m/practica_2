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
    private ListaAsientos lista = new ListaAsientos(24);
    private Nodo lugar; // Nodo para acceder a la info de los lugares

    public void onConfirmButtonCLick(ActionEvent actionEvent) {
        //System.out.println("confirmo");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        lugar = lista.busca(19); //Prueba para acceder a la info del lugar
        if (lugar.disponible) //Prueba para checar disponibilidad
            System.out.println("Lugar libre");
        else
            System.out.println("Lugar ocupado");

        alert.setTitle("Confirmacion");
        alert.setHeaderText(null);
        alert.setContentText("Desea comprar el boleto "+lugar.no_lugar+" con precio de $"+lugar.precio);//Prueba de acceso a la info de un lugar
        alert.showAndWait().ifPresent(response -> {
            if(response.equals(ButtonType.OK)){
                lista.modifica_dis(lugar.no_lugar);//Prueba de cambio de los datos
                System.out.println("confirmacion "+lugar.no_lugar+lugar.disponible);
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