package main;
// food
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Application implements Initializable {

	/*
	 * declared all of the objects needed to have the mainScreen functional
	 */
    @FXML
    private Button emailBreachesButton;

    @FXML
    private Text title;

    @FXML
    private Button passwordGeneratorButton;
    
    @FXML
    private Button passwordStrengthCheckButton;
    
    /*
     * launches the program
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /*
     * loads the scenebuilder file that contains the main screen
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/Comp1050Project.fxml"));
        loader.setController(this); 
        Pane p = loader.load();
        primaryStage.setScene(new Scene(p));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    /*
     * allows for buttons to be pressed to open new files
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailBreachesButton.setOnAction(event -> loadFXML("/main/EmailBreachesScreen.fxml"));
        passwordGeneratorButton.setOnAction(event -> loadFXML("/main/PasswordGeneratorScreen.fxml"));
        passwordStrengthCheckButton.setOnAction(event -> loadFXML("/main/PasswordStrengthCheckScreen.fxml"));
    }

    private void loadFXML(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setController(getControllerForFXML(fxmlPath));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) ((Node) emailBreachesButton).getScene().getWindow();
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object getControllerForFXML(String fxmlPath) {
        switch (fxmlPath) {
            case "/main/EmailBreachesScreen.fxml":
                return new main.EmailBreachesScreenController();
            case "/main/PasswordGeneratorScreen.fxml":
                return new main.PasswordGeneratorScreenController();
            case "/main/PasswordStrengthCheckScreen.fxml":
                return new main.PasswordStrengthCheckScreenController();
            default:
                throw new IllegalArgumentException("Unknown FXML path: " + fxmlPath);
        }
    }
}
