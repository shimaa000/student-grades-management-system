package studentgrades.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import studentgrades.Main;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    @FXML
    private void login() throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("1234")) {
            Main.showPage("dashboard.fxml", "Dashboard");
        } else {
            messageLabel.setText("Wrong username or password.");
        }
    }
}
