package controller;

import gui.StudentFormApplication;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Course;
import model.Student;


import java.io.IOException;
import java.time.LocalDate;

public class StudentsController {

    @FXML
    private Label courseInfo;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> IdColumn;

    @FXML
    private TableColumn<Student, String> carreerColumn;

    @FXML
    private TableColumn<Student, LocalDate> dateColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    @FXML
    private TableColumn<Student, Double> gradeColumn;

    @FXML
    private TableColumn<Student, String> lastNameColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, Integer> semesterColumn;

    private Course course;

    @FXML
    private void initialize() {
        //Tomamos la instancia del curso.
        course = Course.getInstance();
        courseInfo.setText(" Curso: "+course.getName()+" -NRC: "+course.getNrc()+" -Grupo: "+course.getGroup()+" -Total Créditos Acádemicos: "+course.getCredits());
        //Mapeamos las columnas con los atributos del student
        IdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        carreerColumn.setCellValueFactory(new PropertyValueFactory<>("carreer"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        semesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateEntry"));

        //La tabla maneja una lista observable, es decir que cada que se agregue un nuevo estudiante, la info se actualiza
        //Patron Observer
        studentTable.getItems().setAll(course.getStudents());
    }

    @FXML
    private void logOut(ActionEvent event) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Cerrar sesión");
        confirmAlert.setHeaderText("¿Estás seguro que deseas salir?");
        confirmAlert.setContentText("Se cerrará la aplicación por completo.");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getIcons().add(new Image("https://yt3.googleusercontent.com/2__G-ckA66-4JgXPlHTGZvg8CoUIgDU6qYFnJqW-AsVeJvBRT4hCjXz4XMOjIqm4m7v431lT=s900-c-k-c0x00ffffff-no-rj"));

        confirmAlert.showAndWait().ifPresent(response -> {
            if (response.getButtonData().isDefaultButton()) {
                System.exit(0);
            }
        });
    }

    @FXML
    private void returnToRegisterView(ActionEvent event) {
        try{
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            StudentFormApplication.openWindow("/gui/register/register.fxml");
        } catch (IOException e) {
            showNewViewError();
        }
    }

    private void showNewViewError() {
        AlertUtils.createAlert(Alert.AlertType.ERROR, "No se pudo abrir la nueva ventana", "Intentar de nuevo", "La vista no se encuentra o hay un error con ella");
    }
}
