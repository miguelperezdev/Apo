package controller;
import model.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ControllerTriqui {

    private Controller logica = new Controller();

    @FXML private Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve;

    @FXML
    private void initialize() {
        asociarBoton(uno, 0, 0);
        asociarBoton(dos, 0, 1);
        asociarBoton(tres, 0, 2);
        asociarBoton(cuatro, 1, 0);
        asociarBoton(cinco, 1, 1);
        asociarBoton(seis, 1, 2);
        asociarBoton(siete, 2, 0);
        asociarBoton(ocho, 2, 1);
        asociarBoton(nueve, 2, 2);
    }

    private void asociarBoton(Button boton, int fila, int columna) {
        boton.setOnAction(e -> {
            String resultado = logica.jugar(fila, columna);
            if (resultado == null) return;

            if (resultado.equals("EMPATE")) {
                boton.setText("");
                mostrarAlerta("¡Empate!");
                reiniciar();
            } else if (resultado.startsWith("GANADOR_")) {
                String ganador = resultado.split("_")[1];
                mostrarAlerta("¡Ganó " + ganador + "!");
                reiniciar();
            } else {
                boton.setText(resultado);
            }
        });
    }

    private void reiniciar() {
        logica.reiniciar();
        for (Button b : new Button[]{uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve}) {
            b.setText("");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultado");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
