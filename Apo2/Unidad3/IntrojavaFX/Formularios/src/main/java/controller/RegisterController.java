package controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.Student;

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Optional;

public class RegisterController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField ageField;

    @FXML
    private ComboBox<String> genderBox;

    @FXML
    private ComboBox<String> majorBox;

    @FXML
    private TextField semesterField;

    @FXML
    private DatePicker admissionDatePicker;

    @FXML
    private Button registerButton;

    @FXML
    private Button browseImageButton;

    @FXML
    private ImageView imagePreview;

    private Image studentPhoto; // Se usará para guardar la imagen cargada

    @FXML
    public void initialize() {
        // Inicializar ComboBoxes
        genderBox.getItems().addAll("Male", "Female", "Other");
        majorBox.getItems().addAll("Engineering", "Medicine", "Law", "Business", "Arts");

        // Evento del botón de imagen
        browseImageButton.setOnAction(e -> loadImage());

        // Evento del botón de registrar
        registerButton.setOnAction(e -> registerStudent());
    }

    private void loadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Student Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            studentPhoto = new Image(file.toURI().toString());
            imagePreview.setImage(studentPhoto);
        }
    }

    private void registerStudent() {
        try {
            String name = firstNameField.getText();
            String lastName = lastNameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderBox.getValue();
            String major = majorBox.getValue();
            int semester = Integer.parseInt(semesterField.getText());
            String admissionDate = (admissionDatePicker.getValue() != null)
                    ? admissionDatePicker.getValue().toString()
                    : "";

            // Aquí podrías generar un código aleatorio o pedirlo desde otro campo
            String code = "A" + System.currentTimeMillis(); // ejemplo temporal

            Student student = new Student(name, lastName, code, major, gender, age, semester, admissionDate, studentPhoto);
            System.out.println("Student registered: " + student);

            // Acá deberías añadir el estudiante a un curso o a tu modelo general

        } catch (NumberFormatException ex) {
            System.err.println("Error: Age and Semester must be numbers.");
        } catch (Exception ex) {
            System.err.println("Error registering student: " + ex.getMessage());
        }
    }
}
