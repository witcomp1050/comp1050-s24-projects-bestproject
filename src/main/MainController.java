package main;
// food
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    
    private static Stage primaryStage;

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
        MainController.primaryStage = primaryStage;
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
    	
    	/*
    	 * when the email button is pressed, new fxml file opens,
    	 */
    	
        emailBreachesButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/EmailBreachesScreen.fxml"));
                loader.setController(new main.EmailBreachesScreenController());
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                
                Stage stage = (Stage) emailBreachesButton.getScene().getWindow();
                
                stage.setScene(scene);
                stage.show();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        /*
    	 * when the password generator button is pressed, new fxml file opens,
    	 */
        passwordGeneratorButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/PasswordGeneratorScreen.fxml"));
                loader.setController(new main.PasswordGeneratorScreenController()); // Set the controller
                Parent root = loader.load();

                Scene scene = new Scene(root);

                Stage stage = (Stage) passwordGeneratorButton.getScene().getWindow();

                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        /*
    	 * when the password strength check button is pressed, new fxml file opens,
    	 */
        passwordStrengthCheckButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/PasswordStrengthCheckScreen.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                
                Stage stage = (Stage) passwordStrengthCheckButton.getScene().getWindow();
                
                stage.setScene(scene);
                stage.show();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
    }
    /*
     * reloads the mainScreen for when back buttons are pressed
     */
    public static void showMainScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("/main/Comp1050Project.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
