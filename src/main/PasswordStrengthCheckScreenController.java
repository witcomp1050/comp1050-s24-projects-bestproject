package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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

        // Set the generated password to the Label
        passwordStrengthLabel.setText(passwordStrength);
    }
    

}
