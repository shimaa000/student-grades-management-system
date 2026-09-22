package studentgrades.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import studentgrades.Main;
import studentgrades.model.Grade;
import studentgrades.model.Student;
import studentgrades.util.FileManager;

import java.util.ArrayList;

public class ViewStudentsController {
    @FXML private TextArea studentsArea;

    @FXML
    private void initialize() {
        loadStudents();
    }

    @FXML
    private void loadStudents() {
        ArrayList<Student> students = FileManager.readStudents();
        ArrayList<Grade> grades = FileManager.readGrades();
        StringBuilder text = new StringBuilder();

        if (students.isEmpty()) {
            studentsArea.setText("No students found.");
            return;
        }

        for (Student student : students) {
            text.append("ID: ").append(student.getId()).append("\n");
            text.append("Name: ").append(student.getName()).append("\n");
            text.append("Major: ").append(student.getMajor()).append("\n");
            text.append("Grades:\n");

            boolean hasGrades = false;
            for (Grade grade : grades) {
                if (grade.getStudentId().equals(student.getId())) {
                    text.append(" - ").append(grade.getCourse()).append(": ").append(grade.getGrade()).append("\n");
                    hasGrades = true;
                }
            }

            if (!hasGrades) {
                text.append(" No grades added.\n");
            }
            text.append("----------------------\n");
        }

        studentsArea.setText(text.toString());
    }

    @FXML private void back() throws Exception { Main.showPage("dashboard.fxml", "Dashboard"); }
}
