package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

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
        ScreenSwitcher.switchScreen("/main/Comp1050Project.fxml", new MainController());
    }
}


