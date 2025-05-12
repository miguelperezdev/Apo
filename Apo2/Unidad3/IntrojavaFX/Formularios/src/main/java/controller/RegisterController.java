package controller;

import customexceptions.DuplicateStudentException;
import customexceptions.QuotaEnrollExceededException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.Node;
import model.*;

import java.io.File;
import java.time.LocalDate;

public class RegisterController {

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField ageField;
    @FXML private ComboBox<String> genderBox;
    @FXML private ComboBox<String> majorBox;
    @FXML private TextField emailField;
    @FXML private TextField semesterField;
    @FXML private DatePicker admissionDatePicker;
    @FXML private ImageView imagePreview;
    @FXML private Button browseImageButton;
    @FXML private Button registerButton;

    private Course course;
    private String selectedImagePath = null;

    @FXML
    private void initialize() {
        course = Course.getInstance();  // Singleton
        genderBox.getItems().addAll("MALE", "FEMALE", "OTHER");
        majorBox.getItems().addAll("SYSTEM_ENGINEERING", "TELEMATIC_ENGINEERING");
    }

    @FXML
    private void browseImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
        if (file != null) {
            selectedImagePath = file.getAbsolutePath();
            imagePreview.setImage(new Image(file.toURI().toString()));
        }
    }

    @FXML
    private void registerStudent(ActionEvent event) {
        try {
            String name = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String ageStr = ageField.getText();
            String semesterStr = semesterField.getText();
            String genderStr = genderBox.getValue();
            String majorStr = majorBox.getValue();
            LocalDate admissionDate = admissionDatePicker.getValue();
            Image fxImage = imagePreview.getImage();

            validateInputs(name, lastName, email, ageStr, semesterStr, genderStr, majorStr, admissionDate, fxImage);

            int age = Integer.parseInt(ageStr);
            int semester = Integer.parseInt(semesterStr);
            Career major = Career.valueOf(majorStr);
            Gender gender = Gender.valueOf(genderStr);
            String id = generateShortId();

            String result = course.addStudent(
                    name, lastName, "0000", major, gender,
                    age, semester, admissionDate, fxImage, email, id
            );

            showAlert(Alert.AlertType.INFORMATION, "Registro Exitoso", result);
            clearForm();

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error de formato", "Edad y semestre deben ser números válidos.");
        } catch (IllegalArgumentException iae) {
            showAlert(Alert.AlertType.ERROR, "Error de validación", iae.getMessage());
        } catch (DuplicateStudentException | QuotaEnrollExceededException e) {
            showAlert(Alert.AlertType.ERROR, "Registro Fallido", e.getMessage());
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error inesperado", e.getMessage());
            e.printStackTrace();
        }
    }

    private void validateInputs(String name, String lastName, String email, String ageStr,
                                String semesterStr, String genderStr, String majorStr,
                                LocalDate admissionDate, Image fxImage) {

        if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || ageStr.isEmpty() ||
                semesterStr.isEmpty() || genderStr == null || majorStr == null ||
                admissionDate == null || fxImage == null) {
            throw new RuntimeException("Por favor complete todos los campos.");
        }

        if (!email.endsWith("@u.icesi.edu.co")) {
            throw new IllegalArgumentException("El correo debe terminar en @u.icesi.edu.co");
        }

        int age = Integer.parseInt(ageStr);
        if (age < 16 || age > 120) {
            throw new IllegalArgumentException("La edad debe estar entre 16 y 120 años.");
        }

        int semester = Integer.parseInt(semesterStr);
        if (semester < 1 || semester > 10) {
            throw new IllegalArgumentException("El semestre debe estar entre 1 y 10.");
        }

        if (!admissionDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de admisión debe ser anterior a hoy.");
        }
    }

    private void clearForm() {
        firstNameField.clear();
        lastNameField.clear();
        ageField.clear();
        genderBox.getSelectionModel().clearSelection();
        majorBox.getSelectionModel().clearSelection();
        semesterField.clear();
        emailField.clear();
        admissionDatePicker.setValue(null);
        imagePreview.setImage(null);
        selectedImagePath = null;
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private String generateShortId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
}
