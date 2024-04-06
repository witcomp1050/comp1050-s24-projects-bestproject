package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ScreenSwitcher {
    private static Stage stage;

    public static void setStage(Stage stage) {
        ScreenSwitcher.stage = stage;
    }

    public static void switchScreen(String fxmlPath, Object controller) {
        try {
            FXMLLoader loader = new FXMLLoader(controller.getClass().getResource(fxmlPath));
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
