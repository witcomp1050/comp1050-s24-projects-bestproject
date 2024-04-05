package main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class PasswordStrengthCheckScreenController {


    @FXML
    private TextField enterPasswordTextField;

    @FXML
    private Label passwordStrengthLabel;
    

    @FXML
    private void checkStrengthButtonClicked() {
    	
    	String password = enterPasswordTextField.getText();

        String passwordStrength = passwordStrengthCheck.checkStrength(password);

        // Set the result of checkStrength to the text of the label
        passwordStrengthLabel.setText(passwordStrength);
    }
    

}
