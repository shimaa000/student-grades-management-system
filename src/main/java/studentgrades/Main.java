package studentgrades;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        showPage("login.fxml", "Student Grades Manager");
    }

    public static void showPage(String fxmlFile, String title) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/studentgrades/" + fxmlFile));
        Scene scene = new Scene(loader.load(), 700, 500);
        mainStage.setTitle(title);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
