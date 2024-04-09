package main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


/**
 * Controller class for the password strength check screen.
 */
public class PasswordStrengthCheckScreenController {


    @FXML
    private TextField enterPasswordTextField;

    @FXML
    private Label passwordStrengthLabel;
    

    
    /**
     * Check strength button click event.
     */
    @FXML
    private void checkStrengthButtonClicked() {
    	
        // Get the password entered by the user
    	String password = enterPasswordTextField.getText();

        // Check the strength of the password
        String passwordStrength = passwordStrengthCheck.checkStrength(password);

        // Set the result of checkStrength to the text of the label
        passwordStrengthLabel.setText(passwordStrength);
    }
    
    /**
     * Back button click event.
     */
    @FXML
    private void backButtonClicked() {
        // Switch back to the main screen
        ScreenSwitcher.switchScreen("/main/Comp1050Project.fxml", new MainController());
    }
 


}
