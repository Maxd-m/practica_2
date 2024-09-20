package com.example.practica_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    private FlowPane asientos_fp;
    @FXML
    private Label welcomeText;
    @FXML
    private HBox botones_salir;
    @FXML
    private ComboBox CB_asientos;
    private ListaAsientos lista = new ListaAsientos(24);
    private Nodo lugar; // Nodo para acceder a la info de los lugares

    public void onConfirmButtonCLick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        lugar = lista.busca(CB_asientos.getSelectionModel().getSelectedIndex() + 1); // Acceder a la info del lugar

        // Verificar disponibilidad del asiento
        if (!lugar.disponible) {
            Alert alertOccupied = new Alert(Alert.AlertType.WARNING);
            alertOccupied.setTitle("Asiento no disponible");
            alertOccupied.setHeaderText(null);
            alertOccupied.setContentText("El asiento " + lugar.no_lugar + " ya está ocupado.");
            alertOccupied.showAndWait();
            return; // Salir del método si el asiento está ocupado
        }

        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText("Desea comprar el boleto " + lugar.no_lugar + " con precio de $" + lugar.precio);
        alert.showAndWait().ifPresent(response -> {
            if (response.equals(ButtonType.OK)) {
                lista.modifica_dis(lugar.no_lugar); // Cambiar disponibilidad
                System.out.println("Confirmación " + lugar.no_lugar + " " + lugar.disponible);

                // Cambiar color del rectángulo correspondiente
                Rectangle asiento = (Rectangle) asientos_fp.getChildren().get(lugar.no_lugar - 1);
                asiento.setFill(Color.RED);

                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setTitle("Confirmación");
                alert2.setHeaderText(null);
                alert2.setContentText("¿Desea comprar otro boleto?");
                alert2.showAndWait().ifPresent(response2 -> {
                    if (response2.equals(ButtonType.OK)) {
                        CB_asientos.getSelectionModel().clearSelection();
                    } else {
                        System.exit(0);
                    }
                });
            } else {
                System.out.println("No confirma");
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
        asientos_fp.setPrefWrapLength(600);
        asientos_fp.setMinSize(650, 220);
        asientos_fp.setMinSize(650,220);
        for (int i = 1; i <25 ; i++) {
            CB_asientos.getItems().add(i);
            asientos_fp.getChildren().add(new Rectangle(100, 50, Color.GREEN));
        }
    }
}