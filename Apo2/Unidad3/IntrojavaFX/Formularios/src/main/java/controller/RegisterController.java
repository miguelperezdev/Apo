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
    @FXML private TextField email;
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
        genderBox.getItems().addAll("MALE", "FEMALE", "OTHER"); // Enum Gender
        majorBox.getItems().addAll("SYSTEM_ENGINEERING", "TELEMATIC_ENGINEERING"); // Enum Career
    }

    @FXML
    private void browseImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
        if (file != null) {
            selectedImagePath = file.toURI().toString();
            imagePreview.setImage(new Image(selectedImagePath));
        }
    }

    @FXML
    private void registerStudent(ActionEvent event) {
        try {
            String name = firstNameField.getText();
            String lastName = lastNameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String genderStr = genderBox.getValue();
            String majorStr = majorBox.getValue();
            int semester = Integer.parseInt(semesterField.getText());
            LocalDate admissionDate = admissionDatePicker.getValue();
            Image fxImage = imagePreview.getImage();
            String email = TextField.getText();
            String id = generateShortId(); // Simulado

            if (name.isEmpty() || lastName.isEmpty() || genderStr == null || majorStr == null || admissionDate == null || fxImage == null) {
                showAlert(Alert.AlertType.WARNING, "Incomplete Data", "All fields must be filled.");
                return;
            }

            Career major = Career.valueOf(majorStr);
            Gender gender = Gender.valueOf(genderStr);

            String result = course.addStudent(
                    name, lastName, "0000", major, gender,
                    age, semester, admissionDate, fxImage, email, id
            );

            showAlert(Alert.AlertType.INFORMATION, "Success", result);
            clearForm();

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Age and Semester must be valid numbers.");
        } catch (DuplicateStudentException | QuotaEnrollExceededException e) {
            showAlert(Alert.AlertType.ERROR, "Registration Error", e.getMessage());
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Unexpected Error", e.getMessage());
            e.printStackTrace();
        }
    }

    private void clearForm() {
        firstNameField.clear();
        lastNameField.clear();
        ageField.clear();
        genderBox.getSelectionModel().clearSelection();
        majorBox.getSelectionModel().clearSelection();
        semesterField.clear();
        admissionDatePicker.setValue(null);
        imagePreview.setImage(null);
        selectedImagePath = null;
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.show();
    }

    // Métodos utilitarios simulados
    private String generateEmail(String name, String lastName) {
        return name.toLowerCase() + "." + lastName.toLowerCase() + "@university.edu";
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
