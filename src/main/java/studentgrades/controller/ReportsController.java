package studentgrades.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import studentgrades.Main;
import studentgrades.model.Grade;
import studentgrades.model.Student;
import studentgrades.util.FileManager;

import java.util.ArrayList;

public class ReportsController {
    @FXML private TextArea reportArea;

    @FXML
    private void initialize() {
        generateReport();
    }

    @FXML
    private void generateReport() {
        ArrayList<Student> students = FileManager.readStudents();
        ArrayList<Grade> grades = FileManager.readGrades();
        StringBuilder report = new StringBuilder();

        if (students.isEmpty()) {
            reportArea.setText("No data available.");
            return;
        }

        report.append("Students Report\n");
        report.append("====================\n\n");

        double totalAllGrades = 0;
        int countAllGrades = 0;

        for (Student student : students) {
            double total = 0;
            int count = 0;

            for (Grade grade : grades) {
                if (grade.getStudentId().equals(student.getId())) {
                    total += grade.getGrade();
                    count++;
                }
            }

            report.append(student.getName()).append(" (").append(student.getId()).append(")\n");
            if (count > 0) {
                double average = total / count;
                report.append("Average: ").append(String.format("%.2f", average)).append("\n");
                totalAllGrades += total;
                countAllGrades += count;
            } else {
                report.append("Average: No grades\n");
            }
            report.append("--------------------\n");
        }

        if (countAllGrades > 0) {
            double classAverage = totalAllGrades / countAllGrades;
            report.append("\nClass Average: ").append(String.format("%.2f", classAverage));
        }

        reportArea.setText(report.toString());
    }

    @FXML private void back() throws Exception { Main.showPage("dashboard.fxml", "Dashboard"); }
}
