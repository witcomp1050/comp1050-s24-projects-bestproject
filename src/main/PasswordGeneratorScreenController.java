package main;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
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
       
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(password);
        clipboard.setContent(content);
    }

    @FXML
    private void backButtonClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/Comp1050Project.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) backButtonPassGen.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
