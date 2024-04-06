package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class StageManager {
    private Stage primaryStage;

    public StageManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void switchToScene(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Object controller = loader.getController();

        if (controller instanceof PasswordGeneratorScreenController) {
            ((PasswordGeneratorScreenController) controller).setStageManager(this);
        }
        // Add similar checks and setStageManager calls for other controllers that need it

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
