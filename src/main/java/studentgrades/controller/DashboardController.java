package studentgrades.controller;

import javafx.fxml.FXML;
import studentgrades.Main;

public class DashboardController {
    @FXML private void openAddStudent() throws Exception { Main.showPage("add-student.fxml", "Add Student"); }
    @FXML private void openAddGrade() throws Exception { Main.showPage("add-grade.fxml", "Add Grade"); }
    @FXML private void openViewStudents() throws Exception { Main.showPage("view-students.fxml", "View Students"); }
    @FXML private void openReports() throws Exception { Main.showPage("reports.fxml", "Reports"); }
    @FXML private void logout() throws Exception { Main.showPage("login.fxml", "Login"); }
}
