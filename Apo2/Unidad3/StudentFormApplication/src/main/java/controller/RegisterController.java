package controller;
import customexceptions.DuplicateStudentException;
import customexceptions.QuotaEnrollExceededException;
import gui.StudentFormApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Carreer;
import model.Course;

import java.io.IOException;

import java.io.File;
import java.time.LocalDate;

public class RegisterController {

    @FXML
    private ChoiceBox<Carreer> carreerEnum;

    @FXML
    private DatePicker dateTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField gradeTextField;

    @FXML
    private TextField imageTextField;

    @FXML
    private TextField lastTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField semesterTextField;

    @FXML
    private ImageView studentImage;

    //Relación con curso
    private Course course;

    //____________________________________________________________________________________________________
    @FXML
    private void initialize() {
        //Este metodo me permite cargar lo que necesito previo a mostrar la vista
        imageTextField.setDisable(true);
        carreerEnum.getItems().addAll(Carreer.values());
        course = Course.getInstance();
    }

    //____________________________________________________________________________________________________
    @FXML
    private void BrowseImage(ActionEvent event) {
        //Filechooser=explorador de archivos
        FileChooser fileChooser = new FileChooser();
        //Abro el explorador y el archivo que coloque el usuario será el que se carga
        File fileSelected = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
        if (fileSelected != null) {
            imageTextField.setText(fileSelected.getAbsolutePath());
            studentImage.setImage(new Image(fileSelected.toURI().toString()));
        }
    }

    //____________________________________________________________________________________________________
    @FXML
    //Por defecto el esqueleto de codigo no coloca visibilidad, colocar privado.
    private void registerStudent(ActionEvent event) {
        try {
            //Obtengo la info de los campos
            String name = nameTextField.getText();
            String lastname = lastTextField.getText();
            String email = emailTextField.getText();
            String gradeStr = gradeTextField.getText();
            String image = imageTextField.getText();
            Carreer carreer = carreerEnum.getValue();
            String semesterStr = semesterTextField.getText();
            LocalDate date = dateTextField.getValue();

            validateInputs(name, lastname, email, gradeStr, image, semesterStr, carreer, date);

            //Convierto los valores númericos necesarios
            double grade = Double.parseDouble(gradeStr);
            int semester = Integer.parseInt(semesterStr);

            // Registro
            String result = course.addStudent(name, lastname, carreer, email, semester, grade, date, image);
            //Limpio los campos para un nuevo registro
            clearControls();
            //Muestro la alerta de exito
            showStudentRegistrationConfirmation(result);
        } catch (IllegalArgumentException iae) {
            //Muestro una alerta para cuando no hay valores válidos
            showValidationError(iae.getMessage());
        } catch (RuntimeException e) {
            //Muestro una alerta para cuando los campos obligatorios están vacíos
            showDataWarning(e.getMessage());
        } catch (QuotaEnrollExceededException qeee) {
            //Muestro una alerta para cuando el cupo ya esté lleno
            showStudentRegistrationError(qeee.getMessage());
        } catch (DuplicateStudentException dee) {
            //Muestro una alerta para cuando voy a registrar dos estudiantes con el mismo email
            showStudentRegistrationError(dee.getMessage());
        }
    }

    //Verifico si algún campo está vacío para lanzar una excepción no verificada y mostrar una alerta
    /*También se pueden hacer verificaciones adicionales como que los nombres tengan tamaño máximo,
     * que el dominio del correo sea adecuado i.e: @u.icesi.edu.co, que las notas y el semestre estén
     * en los rangos correctos, que la fecha sea del pasado y no de hoy o el futuro.
     */
    private void validateInputs(String name, String lastname, String email, String gradeStr,
                                String image, String semesterStr, Carreer carreer, LocalDate date) {
        if (name.isEmpty() || lastname.isEmpty() || email.isEmpty() || gradeStr.isEmpty() ||
                image.isEmpty() || semesterStr.isEmpty() || carreer == null || date == null) {
            throw new RuntimeException("Por favor complete todos los campos antes de registrar.");
        }

        if (!email.endsWith("@u.icesi.edu.co")) {
            throw new IllegalArgumentException("El correo debe terminar en @u.icesi.edu.co");
        }

        double grade = Double.parseDouble(gradeStr);
        if (grade < 1.0 || grade > 5.0) {
            throw new IllegalArgumentException("La nota debe estar entre 1.0 y 5.0");
        }

        int semester = Integer.parseInt(semesterStr);
        if (semester < 1 || semester > 10) {
            throw new IllegalArgumentException("El semestre debe estar entre 1 y 10");
        }

        if (!date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha debe ser anterior a hoy");
        }
    }

    //____________________________________________________________________________________________________
    @FXML
    private void clearControls() {
        nameTextField.clear();
        lastTextField.clear();
        emailTextField.clear();
        gradeTextField.clear();
        imageTextField.clear();
        carreerEnum.getSelectionModel().clearSelection();
        semesterTextField.clear();
        dateTextField.setValue(null);
    }
    //____________________________________________________________________________________________________
    @FXML
    private void goToStudentsView(ActionEvent event) {
        try {
            //Intento abrir la nueva ventana y cierro la actual
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            StudentFormApplication.openWindow("/gui/students/students.fxml");
        } catch (IOException ioException) {
            //Muestro una alerta en caso tal de que no se pueda cambiar la vista
            showNewViewError();
        }
    }
    //____________________________________________________________________________________________________
    //Para mejor modularidad la configuración de las alertas las separo por métodos según el caso.
    //Además creo una case que sirva de utils para generar alertas según el tipo

    //Recibo un mensaje para poner el mensaje de error de la excepcion
    private void showDataWarning(String message) {
        AlertUtils.createAlert(Alert.AlertType.WARNING, "Campos Vacios", "Faltan Datos", message);
    }
    //Recibo un mensaje para poner el mensaje de error de la excepcion
    private void showValidationError(String message) {
        AlertUtils.createAlert(Alert.AlertType.ERROR, "Error de validación", "Datos Inválidos", message);
    }

    //Recibo un mensaje para poner el mensaje de retorno del metodo de añadir de Curso
    private void showStudentRegistrationConfirmation(String message) {
        AlertUtils.createAlert(Alert.AlertType.INFORMATION, "Registro Exitoso", "", message + "\nPuede seguir registrando estudiantes o ver la lista completa");
    }
    //Recibo un mensaje para poner el mensaje de error de la excepcion
    private void showStudentRegistrationError(String message) {
        AlertUtils.createAlert(Alert.AlertType.ERROR, "Registro Fallido", "El nuevo estudiante no se puede matricular en este curso", message);
    }

    private void showNewViewError() {
        AlertUtils.createAlert(Alert.AlertType.ERROR, "No se pudo abrir la nueva ventana", "Intentar de nuevo", "La vista no se encuentra o hay un error con ella");
    }
}