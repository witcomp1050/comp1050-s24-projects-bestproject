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

public class PasswordGeneratorScreenController {

    @FXML
    private CheckBox upperCheck;

    @FXML
    private CheckBox lowerCheck;

    @FXML
    private CheckBox numberCheck;

    @FXML
    private CheckBox specialCharCheck;

    @FXML
    private TextField lengthTextField;

    @FXML
    private Label generatedPasswordLabel;
    
    @FXML
    private Button backButtonPassGen;

    @FXML
    private void generatePasswordButtonClicked() {
        // Get the values of each CheckBox and TextField
        boolean wantsUpperCase = upperCheck.isSelected();
        boolean wantsLowerCase = lowerCheck.isSelected();
        boolean wantsNumbers = numberCheck.isSelected();
        boolean wantsSpecialCharacters = specialCharCheck.isSelected();
        int length = Integer.parseInt(lengthTextField.getText());

        // Generate password using the passwordGenerator class
        String password = passwordGenerator.generatePassword(wantsUpperCase, wantsLowerCase,
                wantsNumbers, wantsSpecialCharacters, length);

        // Set the generated password to the Label
        generatedPasswordLabel.setText(password);
    }
    @FXML
    private void backButtonClicked() {
        // Close the current window (Password Generator Screen)
        Stage stage = (Stage) backButtonPassGen.getScene().getWindow();
        stage.close();

        // Show the main screen again
        MainController.showMainScreen();
    }

}
