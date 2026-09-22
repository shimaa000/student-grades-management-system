package studentgrades.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import studentgrades.Main;
import studentgrades.model.Grade;
import studentgrades.util.FileManager;

public class AddGradeController {
    @FXML private TextField studentIdField;
    @FXML private TextField courseField;
    @FXML private TextField gradeField;
    @FXML private Label messageLabel;

    @FXML
    private void addGrade() {
        String studentId = studentIdField.getText().trim();
        String course = courseField.getText().trim();
        String gradeText = gradeField.getText().trim();

        if (studentId.isEmpty() || course.isEmpty() || gradeText.isEmpty()) {
            messageLabel.setText("Please fill all fields.");
            return;
        }

        if (!FileManager.studentExists(studentId)) {
            messageLabel.setText("Student ID not found.");
            return;
        }

        try {
            double grade = Double.parseDouble(gradeText);
            if (grade < 0 || grade > 100) {
                messageLabel.setText("Grade must be between 0 and 100.");
                return;
            }
            FileManager.saveGrade(new Grade(studentId, course, grade));
            studentIdField.clear();
            courseField.clear();
            gradeField.clear();
            messageLabel.setText("Grade saved successfully.");
        } catch (NumberFormatException e) {
            messageLabel.setText("Grade must be a number.");
        }
    }

    @FXML private void back() throws Exception { Main.showPage("dashboard.fxml", "Dashboard"); }
}
