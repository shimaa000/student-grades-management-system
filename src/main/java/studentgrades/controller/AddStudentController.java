package studentgrades.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import studentgrades.Main;
import studentgrades.model.Student;
import studentgrades.util.FileManager;

public class AddStudentController {
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField majorField;
    @FXML private Label messageLabel;

    @FXML
    private void addStudent() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String major = majorField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || major.isEmpty()) {
            messageLabel.setText("Please fill all fields.");
            return;
        }

        if (FileManager.studentExists(id)) {
            messageLabel.setText("Student ID already exists.");
            return;
        }

        FileManager.saveStudent(new Student(id, name, major));
        idField.clear();
        nameField.clear();
        majorField.clear();
        messageLabel.setText("Student saved successfully.");
    }

    @FXML private void back() throws Exception { Main.showPage("dashboard.fxml", "Dashboard"); }
}
